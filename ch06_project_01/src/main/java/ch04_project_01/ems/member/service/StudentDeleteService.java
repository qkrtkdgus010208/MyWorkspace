package ch04_project_01.ems.member.service;

import ch04_project_01.ems.member.Student;
import ch04_project_01.ems.member.dao.StudentDao;

public class StudentDeleteService { // 생성자에서 studentDao를 초기화하고 delete( )를 통하여 학생 정보를 삭제

	private StudentDao studentDao;

	public StudentDeleteService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public void delete(String sNum) {
		if (verify(sNum)) {
			studentDao.delete(sNum);
		} else {
			System.out.println("Student information is available.");
		}
	}

	public boolean verify(String sNum) {
		Student student = studentDao.select
				(sNum);
		return student != null ? true : false;
	}
}
