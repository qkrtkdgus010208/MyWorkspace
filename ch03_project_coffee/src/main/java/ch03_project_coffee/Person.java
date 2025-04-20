package ch03_project_coffee;

public class Person {
	
	private Coffee coffee;
	
	public Person(Coffee coffee) {
		this.coffee = coffee;
	}
	
	public void drink() {
		System.out.println("Drinking " + coffee.getName());
	}
}