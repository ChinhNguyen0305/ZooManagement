package action;

public class Touch extends Action {
	private static final int healthCost = 5;
//	private static final int visitHealthCost = 10;
	private static final int fee = 30;
	private static final String actionType = "touch";

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

}
