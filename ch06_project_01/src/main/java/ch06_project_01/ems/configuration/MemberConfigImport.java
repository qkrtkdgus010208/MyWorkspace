package ch06_project_01.ems.configuration;

import java.util.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import ch06_project_01.ems.utils.InitSampleData;
import ch06_project_01.ems.member.DBConnectionInfo;
import ch06_project_01.ems.member.dao.StudentDao;
import ch06_project_01.ems.member.service.EMSInformationService;
import ch06_project_01.ems.member.service.PrintStudentInformationService;
import ch06_project_01.ems.member.service.StudentAllSelectService;
import ch06_project_01.ems.member.service.StudentDeleteService;
import ch06_project_01.ems.member.service.StudentModifyService;
import ch06_project_01.ems.member.service.StudentRegisterService;
import ch06_project_01.ems.member.service.StudentSelectService;

@Configuration
@Import({MemberConfig2.class, MemberConfig3.class})
public class MemberConfigImport {
	
	@Bean
	public InitSampleData initSampleData() {
		InitSampleData initSampleData = new InitSampleData();
		
		String[] sNums = { "hbs001", "hbs002", "hbs003", "hbs004", "hbs005" };
		initSampleData.setsNums(sNums);
		
		String[] sIds = { "rabbit", "hippo", "raccoon", "elephant", "lion" };
		initSampleData.setsIds(sIds)
		;
		String[] sPws = { "p0001", "p0002", "p0003", "p0004", "p0005" };
		initSampleData.setsPws(sPws);
		
		String[] sNames = { "agatha", "barbara", "chris", "doris", "elva" };
		initSampleData.setsNames(sNames);
		
		int[] sAges = { 19, 22, 20, 27, 19 };
		initSampleData.setsAges(sAges);
		
		char[] sGenders = { 'M', 'W', 'W', 'M', 'M' };
		initSampleData.setsGenders(sGenders);
		
		String[] sMajors = { "English", "Korean", "French", "Philosophy", "History" };
		initSampleData.setsMajors(sMajors);
		
		return initSampleData;
	}
	
	@Bean
	public StudentDao studentDao() {
		return new StudentDao();
	}
	
	@Bean
	public StudentRegisterService studentRegisterService() {
		return new StudentRegisterService(studentDao());
	}
	
	@Bean
	public StudentModifyService studentModifyService() {
		return new StudentModifyService(studentDao());
	}
	
	@Bean
	public StudentDeleteService studentDeleteService() {
		return new StudentDeleteService(studentDao());
	}
	
	@Bean
	public StudentSelectService studentSelectService() {
		return new StudentSelectService(studentDao());
	}
	
	@Bean
	public StudentAllSelectService studentAllSelectService() {
		return new StudentAllSelectService(studentDao());
	}
	
	@Bean
	public PrintStudentInformationService printStudentInformationService() {
		return new PrintStudentInformationService(studentAllSelectService());
	}
}