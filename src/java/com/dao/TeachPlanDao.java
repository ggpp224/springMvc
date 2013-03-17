package com.dao;

import java.util.List;
import java.util.Map;

import com.common.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.entity.TeachPlan;

@Component
public class TeachPlanDao{

	@Autowired 
	private BaseDao baseDao;

	public TeachPlan getTeachPlan(String id){
		return baseDao.findOne("mapper.standard.TeachPlanMapper.getTeachPlan", id);
	}
	
	public int createTeachPlan(TeachPlan teachPlan){
		return baseDao.create("mapper.standard.TeachPlanMapper.insertTeachPlan", teachPlan);
	}	
	
	public int deleteTeachPlan(String id){
		return baseDao.delete("mapper.standard.TeachPlanMapper.deleteTeachPlan", id);
	}
	
	public int deleteTeachPlanBatch(TeachPlan teachPlan){
		return baseDao.delete("mapper.standard.TeachPlanMapper.deleteTeachPlanBatch", teachPlan);
	}
	
	public int deleteTeachPlanBatchByPks(String[] ids){
		return baseDao.delete("mapper.standard.TeachPlanMapper.deleteTeachPlanBatchByPks",ids);
	}
	
	public int updateTeachPlan(TeachPlan teachPlan){
		return baseDao.update("mapper.standard.TeachPlanMapper.updateTeachPlan", teachPlan);
	}
	
	/**
	 * 根据ids获得教学计划列表
	 * @param map
	 * @return
	 */
	public List<TeachPlan> getTeachPlansByIds(String[] teachPlanids){
		return baseDao.findList("mapper.standard.TeachPlanMapper.getTeachPlansByIds", teachPlanids);
	}
	
	public List<TeachPlan> findTeachPlan(TeachPlan teachPlan){
		return baseDao.findList("mapper.standard.TeachPlanMapper.findTeachPlan", teachPlan);
	}
	
	public List<TeachPlan> findTeachPlan(TeachPlan teachPlan,int start,int length){
		return baseDao.findList("mapper.standard.TeachPlanMapper.findTeachPlan", teachPlan,start,length);
	}
	
	public List<TeachPlan> getAllTeachPlan(){
		return baseDao.findList("mapper.standard.TeachPlanMapper.getAllTeachPlan");
	}
}