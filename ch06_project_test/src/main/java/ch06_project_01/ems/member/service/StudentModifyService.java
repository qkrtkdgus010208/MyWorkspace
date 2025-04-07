package ch06_project_01.ems.member.service;

import ch06_project_01.ems.member.Student;
import ch06_project_01.ems.member.dao.StudentDao;

public class StudentModifyService { // 생성자에서 studentDao를 초기화하고, modify( )를 통하여 학생 정보를 수정

	private StudentDao studentDao;

	public StudentModifyService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public void modify(Student student) {
		if (verify(student.getsNum())) {
			studentDao.update(student);
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