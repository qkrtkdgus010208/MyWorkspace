package ch04_project_01.ems.member.service;

import ch04_project_01.ems.member.Student;
import ch04_project_01.ems.member.dao.StudentDao;

public class StudentSelectService {
	
	/* 학생 한 명의 정보를 얻는 기능
	– 다른 Service 클래스와 마찬가지로 생성자에서 전달받은 DAO 객체를
	studentDao 필드에 저장 */
	
	private StudentDao studentDao;
	
	public StudentSelectService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	public Student select(String sNum) {
		if (verify(sNum)) {
			return studentDao.select(sNum);
		} else {
			System.out.println("Student information is not available.");
		}
		return null;
	}
	
	public boolean verify(String sNum) {
		Student student = studentDao.select
				(sNum);
		return student != null ? true : false;
	}
}
