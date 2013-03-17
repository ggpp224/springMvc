package com.entity;

public class TeachPlan{

		private String id = null;
		private String teachPlanName = null;
		private String teachPlanCode = null;
		private String major = null;
		private String trainLevel = null;
		private String eduSystem = null;
		private String eduSystemType = null;
		private String learnLife = null;
		private String minimumCredit = null;
		private String requiredCredit = null;
		private String electiveCredit = null;
		private String degreeAwarded = null;
		private String currentSemesterCode = null;
		private String state = null;
		private java.util.Date updatetime = null;
		private java.util.Date createtime = null;
		private String creator = null;
		private String isRemove = null;
		private String projectId=null;
		public String getProjectId() {
			return projectId;
		}
		public void setProjectId(String projectId) {
			this.projectId = projectId;
		}
		private String beginSemester;
		private String endSemester;
		public String getBeginSemester() {
			return beginSemester;
		}
		public void setBeginSemester(String beginSemester) {
			this.beginSemester = beginSemester;
		}
		public String getEndSemester() {
			return endSemester;
		}
		public void setEndSemester(String endSemester) {
			this.endSemester = endSemester;
		}
		private String courseTypes;
		private String courseCredits;
		private String semesterIds;
		private String courseIds;
		private String classHours;
		
		public String getClassHours() {
			return classHours;
		}
		public void setClassHours(String classHours) {
			this.classHours = classHours;
		}
		private String comEles;
		public String getComEles() {
			return comEles;
		}
		public void setComEles(String comEles) {
			this.comEles = comEles;
		}
		public String getCourseTypes() {
			return courseTypes;
		}
		public void setCourseTypes(String courseTypes) {
			this.courseTypes = courseTypes;
		}
		public String getCourseCredits() {
			return courseCredits;
		}
		public void setCourseCredits(String courseCredits) {
			this.courseCredits = courseCredits;
		}
		public String getSemesterIds() {
			return semesterIds;
		}
		public void setSemesterIds(String semesterIds) {
			this.semesterIds = semesterIds;
		}
		public String getCourseIds() {
			return courseIds;
		}
		public void setCourseIds(String courseIds) {
			this.courseIds = courseIds;
		}
		
		
		public String getId(){
			return id;
		}
		public void setId(String id){
			this.id = id;
		}
		public String getTeachPlanName(){
			return teachPlanName;
		}
		public void setTeachPlanName(String teachPlanName){
			this.teachPlanName = teachPlanName;
		}
		public String getTeachPlanCode(){
			return teachPlanCode;
		}
		public void setTeachPlanCode(String teachPlanCode){
			this.teachPlanCode = teachPlanCode;
		}
		public String getMajor(){
			return major;
		}
		public void setMajor(String major){
			this.major = major;
		}
		public String getTrainLevel(){
			return trainLevel;
		}
		public void setTrainLevel(String trainLevel){
			this.trainLevel = trainLevel;
		}
		public String getEduSystem(){
			return eduSystem;
		}
		public void setEduSystem(String eduSystem){
			this.eduSystem = eduSystem;
		}
		public String getEduSystemType(){
			return eduSystemType;
		}
		public void setEduSystemType(String eduSystemType){
			this.eduSystemType = eduSystemType;
		}
		public String getLearnLife(){
			return learnLife;
		}
		public void setLearnLife(String learnLife){
			this.learnLife = learnLife;
		}
		public String getMinimumCredit(){
			return minimumCredit;
		}
		public void setMinimumCredit(String minimumCredit){
			this.minimumCredit = minimumCredit;
		}
		public String getRequiredCredit(){
			return requiredCredit;
		}
		public void setRequiredCredit(String requiredCredit){
			this.requiredCredit = requiredCredit;
		}
		public String getElectiveCredit(){
			return electiveCredit;
		}
		public void setElectiveCredit(String electiveCredit){
			this.electiveCredit = electiveCredit;
		}
		public String getDegreeAwarded(){
			return degreeAwarded;
		}
		public void setDegreeAwarded(String degreeAwarded){
			this.degreeAwarded = degreeAwarded;
		}
		public String getCurrentSemesterCode(){
			return currentSemesterCode;
		}
		public void setCurrentSemesterCode(String currentSemesterCode){
			this.currentSemesterCode = currentSemesterCode;
		}
		public String getState(){
			return state;
		}
		public void setState(String state){
			this.state = state;
		}
		public java.util.Date getUpdatetime(){
			return updatetime;
		}
		public void setUpdatetime(java.util.Date updatetime){
			this.updatetime = updatetime;
		}
		public java.util.Date getCreatetime(){
			return createtime;
		}
		public void setCreatetime(java.util.Date createtime){
			this.createtime = createtime;
		}
		public String getCreator(){
			return creator;
		}
		public void setCreator(String creator){
			this.creator = creator;
		}
		public String getIsRemove(){
			return isRemove;
		}
		public void setIsRemove(String isRemove){
			this.isRemove = isRemove;
		}
}