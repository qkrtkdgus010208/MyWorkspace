package ch06_project_01.ems.configuration;

import java.util.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
public class MemberConfig2 {
	
	@Bean
	public DBConnectionInfo dev_DBConnectionInfoDev() {
		DBConnectionInfo dbConnectionInfo = new DBConnectionInfo();
		dbConnectionInfo.setUrl("000.000.000.000");
		dbConnectionInfo.setUserId("admin");
		dbConnectionInfo.setUserPw("0000");
		return dbConnectionInfo;
	}
	
	@Bean
	public DBConnectionInfo real_DBConnectionInfoDev() {
		DBConnectionInfo dbConnectionInfo = new DBConnectionInfo();
		dbConnectionInfo.setUrl("111.111.111.111");
		dbConnectionInfo.setUserId("master");
		dbConnectionInfo.setUserPw("1111");
		return dbConnectionInfo;
	}
}