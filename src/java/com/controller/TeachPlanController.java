package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.entity.TeachPlan;
import com.service.TeachPlanService;

@Controller
@RequestMapping(value = "/teachplan")
public class TeachPlanController{

	@Autowired
	private TeachPlanService teachPlanService;

	@RequestMapping()  
	@ResponseBody
	public Map<String, Object> list(){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("list", teachPlanService.getAllTeachPlan());
		map.put("flag", 1);
		return map;
	}

	/**
	 * 分页查询教学计划信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/findTeahchPlan/{flag}",method=RequestMethod.GET)  
	@ResponseBody
	public Map<String, Object> findTeahchPlan(HttpServletRequest request,@PathVariable("flag")String flag){
		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		int page=Integer.parseInt(request.getParameter("page"));    //获取当前页号
		int rows=Integer.parseInt(request.getParameter("rows"));    //获取每页显示记录条数

		String trainLevel= request.getParameter("trainLevel");
		String major= request.getParameter("major");
		String state= request.getParameter("state");
		String teachPlanName= request.getParameter("teachPlanName");

		int start =(page-1)*rows;
		//int end=page*rows;
		TeachPlan info = new TeachPlan();

         info.setState(flag);
		if(!StringUtils.isEmpty(trainLevel)){
			info.setTrainLevel(trainLevel) ;
		}
		if(!StringUtils.isEmpty(major)){
			info.setMajor(major) ;
		}
		if(!StringUtils.isEmpty(state)){
			info.setState(state) ;
		}
		if(!StringUtils.isEmpty(teachPlanName)){
			info.setTeachPlanName(teachPlanName);
		}

		modelMap.put("total",teachPlanService.findTeachPlan(info).size());
		modelMap.put("rows", teachPlanService.findTeachPlan(info,start,rows));
		return modelMap;

	}
	
	
	/**
	 * 分页查询教学计划信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/findTeahchPlanByProjectId",method=RequestMethod.GET)  
	@ResponseBody
	public List<TeachPlan> findTeahchPlanByProjectId(TeachPlan teachPlan,HttpServletRequest request){
		teachPlan.setIsRemove("0");
		return teachPlanService.findTeachPlan(teachPlan);

	}

	@RequestMapping(value="/{id}",method=RequestMethod.GET)  
	@ResponseBody
	public TeachPlan get(@PathVariable String id){
		return teachPlanService.getTeachPlan(id);
	}
	

	
	

	/**
	 * 添加教学计划
	 * @param plan
	 * @return
	 */
	@RequestMapping(value="/create",method=RequestMethod.POST)  
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody 
	public Map<String, Object> create( TeachPlan plan){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			plan.setIsRemove("0");
			UUID uuid = UUID.randomUUID();
			String id = uuid.toString().replaceAll("-", "");
			plan.setId(id);
			teachPlanService.createTeachPlan(plan);
//			String courseTypes=	plan.getCourseTypes();
//			if(StringUtils.isNotEmpty(courseTypes)){
//				String courseType[]=courseTypes.split(",");
//				String courseIds[]=plan.getCourseIds().split(",");
//				String semesterIds[]=plan.getSemesterIds().split(",");
//				String courseCredits[]=plan.getCourseCredits().split(",");
//				String comEles[]=plan.getComEles().split(",");
//				String classHours[]=plan.getClassHours().split(",");
//				for(int i=0;i<courseIds.length;i++){
//					TeachplanCourse teachplanCourse = new TeachplanCourse();
//					teachplanCourse.setTeachplanId(id);
//					teachplanCourse.setCourseType(courseType[i]);
//					teachplanCourse.setCourseId(courseIds[i]);
//					teachplanCourse.setSemesterId(semesterIds[i]);
//					teachplanCourse.setComEle(comEles[i]);
//					teachplanCourse.setClassHour(Integer.parseInt( classHours[i]));
//					teachplanCourse.setCourseCredit(courseCredits[i]);
//					teachplanCourse.setCreatetime(DataTimeUtil.getDataTime());
//					teachplanCourse.setIsRemove("0");
//					teachplanCourseService.createTeachplanCourse(teachplanCourse);
//				}
//			}

			map.put("flag", "0");
			map.put("teachplan", plan);
			map.put("mes", "操作成功，返回到列表");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("flag", "1");
			map.put("mes", "操作失败，退回到列表");
		}
		return map; 
	}


	/**
	 * 逻辑删除单个教学计划
	 * @param info
	 */
	@RequestMapping(value="/delete",method=RequestMethod.POST) 
	@ResponseStatus(HttpStatus.OK)
	public void delete(@RequestBody TeachPlan info){
		info.setIsRemove("1");
		teachPlanService.updateTeachPlan(info);
	}
	
	/**
	 * 启动教学计划
	 * @param info
	 */
	@RequestMapping(value="/recruitPlanStartOpt",method=RequestMethod.POST) 
	@ResponseStatus(HttpStatus.OK)
	public void recruitPlanStartOpt(@RequestBody TeachPlan info){
		info.setState("1");
		teachPlanService.updateTeachPlan(info);
	}
	
	
	/**
	 * 确认完成教学计划
	 * @param info
	 */
	@RequestMapping(value="/recruitPlanEndOpt",method=RequestMethod.POST) 
	@ResponseStatus(HttpStatus.OK)
	public void recruitPlanEndOpt(@RequestBody TeachPlan info){
		info.setState("2");
		teachPlanService.updateTeachPlan(info);
	}
	
	
	
	
	/**
	 * 逻辑删除多个个教学计划
	 * @param info
	 */
	@RequestMapping(value="/deletes",method=RequestMethod.POST,produces="application/json") 
	@ResponseStatus(HttpStatus.OK)
	public void deletes(@RequestBody String[] ids){
		for(int i=0;i<ids.length;i++){
			TeachPlan info = new TeachPlan();
			info.setId(ids[i]);
			info.setIsRemove("1");
			teachPlanService.updateTeachPlan(info);
		}

	}
	@RequestMapping(value="/setSemesters",method=RequestMethod.POST,produces="application/json") 
	@ResponseStatus(HttpStatus.OK)
	public Map<String, Object> setSemesters(@RequestBody Map inMap){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			
		map.put("flag", "0");
		map.put("mes", "设置学期成功，返回到列表");
	} catch (Exception e) {
		e.printStackTrace();
		map.put("flag", "1");
		map.put("mes", "设置学期失败，退回到列表");
	}
	return map; 
	}
	
	
}
