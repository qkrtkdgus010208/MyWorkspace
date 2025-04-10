package ch03_project_coffee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Person {
	
	private Coffee coffee;
	private int age;
	private List<String> favoriteCoffees;
	private String city;

	public Person() {
		
	}
	
	@Autowired
	public Person(@Qualifier("americano") Coffee coffee) {
		this.coffee = coffee;
	}

	 public Person(Coffee coffee, String city) {
		this.coffee = coffee;
		this.city = city;
	}

	public void setAge(int age) {
		this.age = age;

	}

	public void setFavoriteCoffees(List<String> favoriteCoffees) {
		this.favoriteCoffees = favoriteCoffees;
	}

	public void drink() {
		System.out.println("Drinking " + coffee.getName());

		if (city != null) {
			System.out.println("Location: " + city);
		}

		if (age != 0) {
			System.out.println("Age: " + age);
		}

		if (favoriteCoffees != null) {
			System.out.println("Favorite Coffees: " + favoriteCoffees);
		}
		
		System.out.println();
	}
}