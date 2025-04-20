package ch03_project_coffee;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	
	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		Person person1 = ctx.getBean("person1", Person.class);
		person1.drink(); // "Drinking Americano"
		
		Person person2 = ctx.getBean("person2", Person.class);
		person2.drink(); // "Drinking Latte"
	}
}