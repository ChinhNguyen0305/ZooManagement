package terestial;

import action.Action;

public class Lion extends Terrestial {
	private String name;
	private int age;
	private int health;
	private final static String  type = "Lion";

	public Lion(String name, int age) {
		super();
		this.name = name;
		this.age = age;
		this.health = 100;
	}

	@Override
	public void bark() {
		System.out.printf("Hi, I'm %s, a.k.a the King of the forest", this.name).println();
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
		return "Lion name: " + name + ", age:" + age + ", health:" + health;
	}

	@Override
	public void minusHealthAfterAction(Action action) {
		health -= action.getActionHealthCost();
	}

	@Override
	public void barkWhenGetTouched() {
		System.out.println("I'm the Lion king, dont you dare touching me!");
	}

	@Override
	public void setHealthToZeroWhenRiden() {
		this.health = 0;
		
	}

	@Override
	public void barkWhenGetRiden() {
		System.out.println("Sit down");
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
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
