package ch04_project_01.ems.member.service;

import java.util.Map;
import ch04_project_01.ems.member.Student;
import ch04_project_01.ems.member.dao.StudentDao;

public class StudentAllSelectService {
	
	/* 전체 학생 정보를 반환하는 allSelect( ) 메소드 존재
	– 다른 Serivce 클래스와 마찬가지로 생성자를 통하여 studentDao를 초기화 */

	private StudentDao studentDao;

	public StudentAllSelectService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public Map<String, Student> allSelect() {
		return studentDao.getStudentDB();
	}
}
