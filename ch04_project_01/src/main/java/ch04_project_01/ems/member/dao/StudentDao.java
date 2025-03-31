package ch04_project_01.ems.member.dao;

import java.util.HashMap;
import java.util.Map;
import ch04_project_01.ems.member.Student;

public class StudentDao {
	
	/* 일반적인 DAO 클래스와 다르지 않음
	– 데이터베이스에 접속하고, Service에 의해서 호출
	– 데이터의 insert, search, update, delete 등의 기능을 수행
	■ 실제로는 mySQL과 같은 실제 데이터베이스를 사용해야 하지만,
	이번 실습에서는 HashMap을 이용하여 데이터를 저장
	■ studentDB 필드에 학생정보가 저장
	■ key로 사용되는 값은 학생 정보의 고유 값인 sNum(학번)을 이용 */

	private Map<String, Student> studentDB = new HashMap<String, Student>();

	public void insert(Student student) {
		studentDB.put(student.getsNum(), student);
	}

	public Student select(String sNum) {
		return studentDB.get(sNum);
	}

	public void update(Student student) {
		studentDB.put(student.getsNum(), student);
	}

	public void delete(String sNum) {
		studentDB.remove
		(sNum);
	}

	public Map<String, Student> getStudentDB() {
		return studentDB;
	}
}
