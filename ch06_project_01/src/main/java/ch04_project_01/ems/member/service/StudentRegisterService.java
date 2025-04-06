package ch04_project_01.ems.member.service;

import ch04_project_01.ems.member.Student;
import ch04_project_01.ems.member.dao.StudentDao;

public class StudentRegisterService { // 학생 정보를 데이터베이스(지금은 HashMap)에 저장하는 기능
	
	private StudentDao studentDao;
	
	public StudentRegisterService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	public void register(Student student) {
		if (verify(student.getsNum())) {
			studentDao.insert(student);
		} else {
			System.out.println("The student has already registered.");
		}
	}
	
	public boolean verify(String sNum) {
		Student student = studentDao.select
				(sNum);
		return student == null ? true : false;
	}
}