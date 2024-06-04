package sunZoo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.SunZoo.SunZoo.account.jdbc.AccountJdbcRepository;

import action.Action;

@Component
public class Zoo {
	// Attribute
	private String name;
	private String location;
	private List<Cage> cages = new ArrayList<Cage>();
	private List<Plan> plans = new ArrayList<Plan>();
	private int netWorth;

	// Jdbc
	@Autowired
	private AccountJdbcRepository repository;

	// No arg Constructor
	public Zoo() {

	}

	// Constructor
	public Zoo(String name, String address) {
		this.name = name;
		this.location = address;
		this.netWorth = 100; // The initial nw is always 100$ for each Shop.
	}

	// Behavior
	// Just visit a specific cage
	public void visit(int cage) {
		Cage visitedCage = this.getCages().get(cage - 1);
		if (!visitedCage.isAvailable()) {
			System.out.println("Too crowded out there ");
		} else {
			System.out.printf("Welcome to Cage No.%d, enjoy your journey well!", visitedCage.getNo()).println();
			this.netWorth += visitedCage.getPrice();
			visitedCage.setAvailable(false);
			// Minus health for animals in visited cage
			for (Animal animal : visitedCage.getAnimals()) {
				animal.minusHealthAfterVisited();
			}
		}
	}

	// Visit and action <= This is obsolete
//	public void visitAndAction(int cage, Action action) {
//		Cage visitedCage = this.getCages().get(cage - 1);
////		Action triggerAction;
////		for (Action actionInCage : visitedCage.getAction()) {
////			if (actionInCage == action) {
////				triggerAction = actionInCage;
////			}
////		}
//		if (!visitedCage.isAvailable()) {
//			System.out.println("Too crowded out there ");
//		} else {
//			System.out.printf("Welcome to Cage No.%d, enjoy your journey well!", visitedCage.getNo()).println();
//			netWorth += visitedCage.getPrice();
//			netWorth += visitedCage.getAction()[1].getActionFee();
//			visitedCage.setAvailable(false);
//			visitedCage.setHygiene(visitedCage.getHygiene() - 2);
//
//			// Minus health for animals in visited cage
//			for (Animal animal : visitedCage.getAnimals()) {
//				if (action.getActionType() == "touch") {
//					animal.barkWhenGetTouched();
//				} else if (action.getActionType() == "takeARide") {
//					animal.barkWhenGetRiden();
//					animal.setHealthToZeroWhenRiden();
//				}
//			}
//		}
//	}

	public void visitAndAction(int cage, Action action) {
		Cage visitedCage = this.getCages().get(cage - 1);
		String actionName = action.getActionType();
		// Status change
		visitedCage.setAvailable(false);
		visitedCage.setHygiene(visitedCage.getHygiene() - 2);
		// Charge

		netWorth += visitedCage.getPrice();

		for (Animal animal : visitedCage.getAnimals()) {
			netWorth += action.getActionFee();
			switch (actionName) {
			case "touch": {
				animal.barkWhenGetTouched();
				animal.minusHealthAfterAction(action);
				break;
			}
			case "takeARide": {
				animal.barkWhenGetRiden();
				animal.setHealthToZeroWhenRiden();
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + actionName);
			}
		}
	}

	public void visitAndActionUsingString(int cage, String action) {
		Cage visitedCage = this.getCages().get(cage - 1);
		String actionToLower = action.toLowerCase();
//		System.out.println(actionToLower);
		Action triggeredAction = null;
		for (Action theAction : visitedCage.getAction()) {
			if (theAction.getActionType().toLowerCase().equals(action.toLowerCase())) {
//				System.out.println("actionn to lower: " + actionToLower);
//				System.out.println("For's action: " + theAction.getActionType());
//				System.out.println("For's action to lowerCase : " + theAction.getActionType().toLowerCase());
				triggeredAction = theAction;
			}
		}

		// Status change
		visitedCage.setAvailable(false);
		visitedCage.setHygiene(visitedCage.getHygiene() - 2);
		// Charge

		netWorth += visitedCage.getPrice();

		for (Animal animal : visitedCage.getAnimals()) {
			netWorth += triggeredAction.getActionFee();
			switch (triggeredAction.getActionType()) {
			case "touch": {
				animal.barkWhenGetTouched();
				animal.minusHealthAfterAction(triggeredAction);
				break;
			}
			case "takeARide": {
				animal.barkWhenGetRiden();
				animal.setHealthToZeroWhenRiden();
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + actionToLower);
			}
		}
	}

	public void addCage(Cage cage) {
		Cage.number += 1;
		this.cages.add(cage);
	}

	public List<Cage> getCages() {
		return cages;
	}

	public List<Plan> getPlans() {
		return plans;
	}

	public void addPlan(Plan plan) {
		this.plans.add(plan);
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return location;
	}

	public int getNetWorth() {
		return netWorth;
	}

	public void setNetWorth(int netWorth) {
		this.netWorth = netWorth;
	}

	public void feedAnimalInCage(int No) {
		// Feed then plus health
		Cage feededCage = this.getCages().get(No - 1);
		for (Animal animal : feededCage.getAnimals()) {
			animal.plusHealthAfterFeeded();
		}

		// Cost of the feed
		netWorth -= 10;
	}

	@Override
	public String toString() {
		return "Zoo \nZoo's Cages\n" + cages + "netWorth=" + netWorth;
	}

	public void addAnimalToCage(Animal animal, int Cage) {
		repository.addAnimal(animal, Cage);
	}

}
