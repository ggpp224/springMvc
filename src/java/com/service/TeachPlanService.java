package com.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.TeachPlanDao;
import com.entity.TeachPlan;

@Service
@Transactional
public class TeachPlanService{

	@Autowired 
	private  TeachPlanDao teachPlanDao;
	
	public TeachPlan getTeachPlan(String id){
		return teachPlanDao.getTeachPlan(id);
	}
	
	public int createTeachPlan(TeachPlan teachPlan){
		return teachPlanDao.createTeachPlan(teachPlan);
	}
	
	public int updateTeachPlan(TeachPlan teachPlan){
		return teachPlanDao.updateTeachPlan(teachPlan);
	}
	
	
	
	public int deleteTeachPlan(String id){
		return teachPlanDao.deleteTeachPlan(id);
	}
	
	public int deleteTeachPlanBatch(TeachPlan teachPlan){
		return teachPlanDao.deleteTeachPlanBatch(teachPlan);
	}
	
	public int deleteTeachPlanBatchByPks(String[] ids){
		return teachPlanDao.deleteTeachPlanBatchByPks(ids);
	}
	
	public List<TeachPlan> findTeachPlan(TeachPlan teachPlan){
		return teachPlanDao.findTeachPlan(teachPlan);
	}
	
	public List<TeachPlan> findTeachPlan(TeachPlan teachPlan,int start,int length){
		return teachPlanDao.findTeachPlan(teachPlan,start,length);
	}
	
	public List<TeachPlan> getAllTeachPlan(){
		return teachPlanDao.getAllTeachPlan();
	}
	
	public int count(){
		return  teachPlanDao.getAllTeachPlan().size();
	}
	
	public int count(TeachPlan teachPlan){
		return  teachPlanDao.findTeachPlan(teachPlan).size();
	}
	
	public boolean exist(String id){
		return  teachPlanDao.getTeachPlan(id) != null;
	}
}