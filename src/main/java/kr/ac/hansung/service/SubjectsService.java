package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.SubjectDAO;
import kr.ac.hansung.model.Subject;

@Service
public class SubjectsService {

	private SubjectDAO subjectDAO;

	@Autowired
	public void setSubjectDAO(SubjectDAO subjectDAO) {
		this.subjectDAO = subjectDAO;
	}

//	public List<Subject> showSubjects() {
//		// TODO Auto-generated method stub
//		return subjectDAO.getSubjects();
//	}
//
//	public int showCount() {
//		// TODO Auto-generated method stub
//		return subjectDAO.getRowCount();
//	}
	
	public List<Subject> showGradePerPart(){
		return subjectDAO.getGradePerPart();
	}
	
	public List<Subject> showGradePerYearSemester(){
		return subjectDAO.getGradePerYearSemester();
	}
	
	public List<Subject> showSubjectName(int year, int semester){
		return subjectDAO.getSubjectName(year, semester);
	}
	
	public int showSumGrade(){
		return subjectDAO.getSumGrade();
	}
	
	public boolean register(Subject subject){
		return subjectDAO.insert(subject);
	}
	
	public List<Subject> get2017RegisterEntry(){
		return subjectDAO.get2017Register();
	}

}
