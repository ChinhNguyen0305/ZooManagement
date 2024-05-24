package action;

public class Visit extends Action {
	private static final int costHeath = 10;
	private static final int fee = 100;
	private static final String actionType = "visit";
//	private static final int ;

	@Override
	public int getActionFee() {
		return fee;
	}

	@Override
	public int getActionHealthCost() {
		return costHeath;
	}

	@Override
	public String getActionType() {
		return actionType;
	}

}
