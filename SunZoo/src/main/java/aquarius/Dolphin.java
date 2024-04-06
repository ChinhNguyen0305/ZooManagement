package aquarius;

import action.Action;

public class Dolphin implements Aquarius {

	private String name;
	private int age;
	private int health;
	private final static String  type = "Dolphin";

	public Dolphin(String name, int age) {
		super();
		this.name = name;
		this.age = age;
		this.health = 100;

	}

	@Override
	public void bark() {
		System.out.printf("Hi I'm %s, I'm smart, I can help people, too", this.name).println();
	}

	@Override
	public int getHealth() {
		return this.health;
	}

	@Override
	public void minusHealthAfterVisited() {
		this.health -= 5;
	}

	@Override
	public void plusHealthAfterFeeded() {
		health += 5;
	}

	@Override
	public String toString() {
		return "Dolphin name= " + name + ", age=" + age + ", health=" + health ;
	}

	@Override
	public void minusHealthAfterAction(Action action) {
		health -= action.getActionHealthCost();		
	}

	@Override
	public void barkWhenGetTouched() {
		System.out.println("Don't touch my nose");
	}

	@Override
	public void setHealthToZeroWhenRiden() {
		this.health = 0;
		
	}

	@Override
	public void barkWhenGetRiden() {
		System.out.println("Stand up");
	}

	@Override
	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	

}
