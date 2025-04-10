package ch03_project_coffee;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Config {
	
	@Bean
	public Americano americano() {
		return new Americano();
	}
	
	@Bean
	public Latte latte() {
		return new Latte();
	}
	
	@Bean
	public Person person1() {
		Person person = new Person(americano());
		person.setAge(25);
		return person;
	}
	
	@Bean
	public Person person2() {
		Person person = new Person(latte());
		person.setFavoriteCoffees(Arrays.asList("Espresso", "Cappuccino", "Mocha"));
		return person;
	}
	
	@Bean
	public Person person3() {
		return new Person(americano(), "Seoul");
	}
}