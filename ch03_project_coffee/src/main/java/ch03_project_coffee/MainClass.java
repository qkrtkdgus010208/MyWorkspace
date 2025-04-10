package ch03_project_coffee;

import java.lang.annotation.Annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new
				AnnotationConfigApplicationContext(Config.class);
		
		Person person1 = ctx.getBean("person1", Person.class);
		System.out.println(" Person 1 ---");
		person1.drink(); // "Drinking Americano"
		
		Person person2 = ctx.getBean("person2", Person.class);
		System.out.println(" Person 2 ---");
		person2.drink(); // "Drinking Latte"
		
		Person person3 = ctx.getBean("person3", Person.class);
		System.out.println(" Person 3 ---");
		person3.drink(); // "Drinking Latte"
	}
}