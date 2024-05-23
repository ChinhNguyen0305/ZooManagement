package terestial;

import action.Action;

public class Bear extends Terrestial {
	private final String type = "Bear";
	private String name;
	private int age;
	private int healPoint;

	// Random heal when add a new animal
	int maxHeathlPoint = 100;

	public Bear(String name) {
		super();
		this.name = name;
		this.healPoint = maxHeathlPoint;
	}

	@Override
	public void bark() {
		System.out.println("Honeyyy");

	}

	public int getHealPoint() {
		return healPoint;
	}

	public void setHealPoint(int healPoint) {
		this.healPoint = healPoint;
	}

	public String toString() {
		return String.format("I am %s, Honeyyy!!!", this.name);
	}

	@Override
	public void minusHealthAfterVisited() {
		// TODO Auto-generated method stub

	}

	@Override
	public void plusHealthAfterFeeded() {
		// TODO Auto-generated method stub

	}

	@Override
	public void minusHealthAfterAction(Action action) {
		// TODO Auto-generated method stub

	}

	@Override
	public void barkWhenGetTouched() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setHealthToZeroWhenRiden() {
		// TODO Auto-generated method stub

	}

	@Override
	public void barkWhenGetRiden() {
		// TODO Auto-generated method stub

	}

	@Override
	public int getHealth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int getAge() {
		return age;
	}

}
