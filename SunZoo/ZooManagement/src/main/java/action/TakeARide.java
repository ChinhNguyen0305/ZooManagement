package action;

import sunZoo.Animal;

public class TakeARide implements Action {
	private static final int fee = 200;
	private static final String actionType = "takeARide";
	private static final int healthCost = 10;

	@Override
	public int getActionFee() {
		return fee;
	}

	@Override
	public int getActionHealthCost() {
		return healthCost;
	}

	@Override
	public String getActionType() {
		return actionType;
	}
	
	public static void set0(Animal animal) {
		animal.setHealthToZeroWhenRiden();
	}

}
