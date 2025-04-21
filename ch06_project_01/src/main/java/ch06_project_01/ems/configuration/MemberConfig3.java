package ch06_project_01.ems.configuration;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
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
public class MemberConfig3 {
	
	@Autowired
	DBConnectionInfo dev_DBConnectionInfoDev;
	
	@Autowired
	DBConnectionInfo real_DBConnectionInfoDev;
	
	@Bean
	public EMSInformationService eMSInformationService() {
		EMSInformationService emsInformationService = new EMSInformationService();
		emsInformationService.setInfo("Education Management System program was developed in 2022.");
		emsInformationService.setCopyRight(
				"COPYRIGHT(C) 2022 EMS CO., LTD. ALL RIGHT RESERVED. CONTACT MASTER FOR MORE INFORMATION.");
		emsInformationService.setVer("The version is 1.0");
		emsInformationService.setsYear(2022);
		emsInformationService.setsMonth(3);
		emsInformationService.setsDay(1);
		emsInformationService.seteYear(2022);
		emsInformationService.seteMonth(4);
		emsInformationService.seteDay(30);
		
		List<String> developers = new ArrayList<String>();
		developers.add("Cheney.");
		developers.add("Eloy.");
		developers.add("Jasper.");
		developers.add("Dillon.");
		developers.add("Kian.");
		emsInformationService.setDevelopers(developers);
		
		Map<String, String> administrators = new HashMap<String, String>();
		administrators.put("Cheney", "cheney@springPjt.org");
		administrators.put("Jasper", "jasper@springPjt.org");
		emsInformationService.setAdministrators(administrators);
		
		Map<String, DBConnectionInfo> dbInfos = new HashMap<String, DBConnectionInfo>();
		dbInfos.put("dev", dev_DBConnectionInfoDev);
		dbInfos.put("real", real_DBConnectionInfoDev);
		emsInformationService.setDbInfos(dbInfos);
		
		return emsInformationService;
	}
}