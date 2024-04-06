package sunZoo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import aquarius.Dolphin;
import terestial.Lion;

public class ZooRunner {

	public static void main(String[] args) {
		Zoo SunZoo = new Zoo("Sun's World", "Da Nang");
		SunZoo.addCage(new Cage(200, new ArrayList<Animal>(List.of(new Lion("the King", 10)))));
		SunZoo.addCage(new Cage(150,
				new ArrayList<Animal>(List.of(new Dolphin("dolphin the eve", 10), new Lion("The chuppy Lion", 3)))));
		SunZoo.addCage(new Cage(110, new ArrayList<Animal>(List.of(new Lion("the cup", 10)))));
		SunZoo.addCage(new Cage(220, new ArrayList<Animal>(List.of(new Dolphin("the smart day", 10)))));

//		ArrayList<Cage> SunCages = SunZoo.getCages();

		// Zoo test add Plan
		SunZoo.addPlan(new Plan("November big sale!!", 50));
		SunZoo.addPlan(new Plan("Chilling Monday", 10));
		SunZoo.addPlan(new Plan("Hot Tuesday", 30));
		SunZoo.addPlan(new Plan("Water Wednesday", 15));
		SunZoo.addPlan(new Plan("The Thursday", 25));

//		ArrayList<Plan> SunZooPlan = SunZoo.getPlans();

		// Test cage no
//		for (Cage cage : SunCages) {
//			System.out.println(cage.getNo());
//		}

		// Test cage toString1
//		System.out.println("****** \nTest Cages");
//		for (Cage cage : SunZoo.getCages()) {
//			System.out.println(cage);
//		}
//
//		// Cage toString after discount
//		if (!SunZooPlan.isEmpty()) {
//			for (Cage cage : SunCages) {
//				cage.setPrice(cage.getPrice() * SunZooPlan.get(0).getDiscount() / 100);
//			}
//		}
//		System.out.println("****** \nTest Cages price after discount \n");
//		for (Cage cage : SunZoo.getCages()) {
//			System.out.println(cage);
//		}
//
//		// Test animal toString
//		System.out.println("****** \nTest AddAnimal\n");
//
//		Cage SunCage1 = SunZoo.getCages().get(0);
//		SunCage1.addAnimal(new Dolphin("Eve", 12));
//
//		for (Animal animal : SunCage1.getAnimals()) {
//			animal.bark();
//		}
//
//		// Test initial NW
//		System.out.println("******\nInital Networth");
//		System.out.println(SunZoo.getNetWorth());
//
//		// Test Visit and Networth
//		System.out.println("******");
//		System.out.printf("Networth before the visit: %d", SunZoo.getNetWorth()).println();
//		SunZoo.visit(1);
//		System.out.printf("Networth after the visit: %d", SunZoo.getNetWorth()).println();
//
//		// 2023/11/18 Test animal's health
//		System.out.println(SunCage1.getAnimals().get(0));
//
//		// 2023/11/18 Test set health After visit Cage 1
//		System.out.println("*******\nTest health after visit cage 1");
//		SunZoo.visit(1);
//		
//		
//		System.out.println(SunCage1.getAnimals().toString()); //LOOK AT THIS toString
//		System.out.println("*****\nTest health after being visited");		
//		for(Animal animal:SunCage1.getAnimals()) {
//			System.out.println(animal.toString());
//		}
//		
//		//Test health and Zoo's NW after feeding
//		SunZoo.feedAnimalInCage(1);
//		System.out.println(SunCage1.getAnimals().toString());
//		System.out.println("*****\nTest health after being feed");		
//		for(Animal animal:SunCage1.getAnimals()) {
//			System.out.println(animal.toString());
//		}

		// Cage 2 Testing
		// GetCage 2
//		System.out.println("******\nCage 2 Testing");
//		Cage SunCage2 = SunZoo.getCages().get(1);
////		System.out.println(SunCage2.getAnimals().toString());
//		// Touch cage2
////		SunZoo.visitAndAction(2, new TakeARide());
//		SunZoo.visitAndAction(2, new Touch());
////		System.out.println(SunCage2.toString());
////		SunZoo.visitAndActionString(2, "takeARide");
//		// Test status
//		System.out.println("*****\nTest Zoo's status");
////		System.out.println(SunZoo.toString());
////		System.out.println(SunCage2.getAction().toString());
////		Check Action 
////		System.out.println(());
//		for (Action action : SunCage2.getAction()) {
//			System.out.println(action.getActionType());
//		}
//		
//		//Test Visit and actionUsingString
//		SunZoo.visitAndActionUsingString(2, "tAkeARide"); 

		Scanner scanner = new Scanner(System.in);
		Scanner scannerForAddCage = new Scanner(System.in);
		System.out.print("Input your choice: ");
		int choice;
		do {
			System.out.println("****Welcom to SunWorldZoo****\nWhat do you want to do.");
			System.out.println("1. Check Zoo's Information. ");
			System.out.println("2. AddCage. ");
			System.out.println("3. Visit.");
			System.out.println("9. Exit console.");
			choice = scanner.nextInt();

			switch (choice) {
			case 1: {
				System.out.println(SunZoo.toString());
				break;
			}
			case 2: {
				System.out.print("Insert price: ");
				int addedPrice = scanner.nextInt();
				int addedAnimalChoice;
				ArrayList<Animal> addedCageAnimal = new ArrayList<>();
//				ArrayList<String> addedAnimalList = new ArrayList<String>();
				do {
					System.out.println("What kind of animals:");
					System.out.println("1. Lion");
					System.out.println("2. Dolphil");
					System.out.println("3. I'm done.");
					addedAnimalChoice = scannerForAddCage.nextInt();

					final int Lion = 1;
					final int Dolphin = 2;
					switch (addedAnimalChoice) {
					case Lion: {
						System.out.print("Enter lion's name: ");
						String lionName = scanner.next();
						System.out.print("Enter lion's weight:");
						int lionWeight = scanner.nextInt();
						addedCageAnimal.add(new Lion(lionName, lionWeight));
						break;
					}
					case Dolphin: {
						System.out.println("Enter dolphin's name: ");
						String dolphinName = scanner.next();
						System.out.print("Enter dolphin's weight:");
						int dolphinWeight = scanner.nextInt();
						addedCageAnimal.add(new Dolphin(dolphinName, dolphinWeight));
						break;
					}
					}
				} while (addedAnimalChoice != 3);
//				
				
				//Process's follow: check array size, if there is just 1, and if just two, we hardcoded this into 2 patter, only1 animal, and if2, that must be 1 lion and 1 dolphin
//				if (addedAnimalList.size() >= 2) {
////					SunZoo.addCage(new Cage(addedPrice, new ArrayList<Animal>(List
////							.of(new Lion("Added lion by switch case", 10), new Dolphin("dolphin added by SC", 2)))));
//					for (String animal : addedAnimalList) {
//						if (animal.toLowerCase().equals("lion")) {
//							addedCage.add(new Lion("abc", 10));
//						} else if (animal.toLowerCase().equals("dolphin")) {
//							addedCage.add(new Dolphin("abc", 10));
//						}
//					}
//				} else if (addedAnimalList.size() == 1) {
//					for (String addedAnimal : addedAnimalList) {
//						if (addedAnimal.toLowerCase().equals("lion")) {
//							SunZoo.addCage(new Cage(addedPrice,
//									new ArrayList<Animal>(List.of(new Lion("Added lion by switch case", 10)))));
//						} else
//							SunZoo.addCage(new Cage(addedPrice,
//									new ArrayList<Animal>(List.of(new Dolphin("Added dolphil by switch case", 3)))));
//					}
//				}
				
				//Process's follow: we don't hard-code anything, we add animal to a List, and then use cage constructor to generate addedcage and then add that cage into Zoo via zoo.addCage function
				SunZoo.addCage(new Cage(addedPrice, addedCageAnimal));

				break;

			} // Case 2
			case 3: {
				System.out.println("Choose cage to vist");
				int visitedCage = scanner.nextInt();
				System.out.println("Do you want to just vist or action\n1. Just visit\n2. Visit and take action");
				int visitOrVisitAndAction = scanner.nextInt();
				final int justVisit = 1;
				final int visitAndAction = 2;

				switch (visitOrVisitAndAction) {
				case justVisit: {

					SunZoo.visit(visitedCage);
					break;
				}
				case visitAndAction: {
					System.out.println("Choose action:\n1. Visit and Touch\n2. Visit and taking a ride");
					int selectedAction = scanner.nextInt();
					final int visitAndTouch = 1;
					final int visitAndTakeARide = 2;

					switch (selectedAction) {
					case visitAndTouch: {
						SunZoo.visitAndActionUsingString(visitedCage, "touch");
						break;
					}
					case visitAndTakeARide: {
						SunZoo.visitAndActionUsingString(visitedCage, "takearide");
						break;
					}
					}

				}

				}
			}

			}
		} while (choice != 9);

		// Close scanner
		scanner.close();
		scannerForAddCage.close();
	}
}
