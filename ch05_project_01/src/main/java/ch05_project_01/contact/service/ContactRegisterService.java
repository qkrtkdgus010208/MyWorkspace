package ch05_project_01.contact.service;

import ch05_project_01.contact.ContactSet;
import ch05_project_01.contact.dao.ContactDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import javax.annotation.Resource;

public class ContactRegisterService {
	
	@Autowired
	private ContactDao contactDao;
	
	public ContactRegisterService() {
		System.out.println("default constructor");
	}

	public ContactRegisterService(ContactDao contactDao) {
		System.out.println("contactDao: " + contactDao); // contactDao 출력
		
		this.contactDao = contactDao;
	}
	
	public void register(ContactSet contactSet) {
		String name = contactSet.getName();
		if (verify(name)) {
			contactDao.insert(contactSet);
		} else {
			System.out.println("The name has already registered.");
		}
	}
	
	public boolean verify(String name) {
		ContactSet contactSet = contactDao.select(name);
		return contactSet == null ? true : false;
	}
	
	public void setContactDao(ContactDao contactDao) {
		System.out.println("setter");
		
		this.contactDao = contactDao;
	}
}
