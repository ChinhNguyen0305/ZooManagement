package com.SunZoo.SunZoo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.SunZoo.SunZoo.account.Account;
import com.SunZoo.SunZoo.account.jdbc.AccountJdbcRepository;

import aquarius.Dolphin;
import sunZoo.Animal;
import sunZoo.Cage;
import sunZoo.Zoo;
import terestial.Lion;

@SpringBootApplication
public class SunZooApplication {
	public static void main(String[] args) {
		SpringApplication.run(SunZooApplication.class, args);

		Zoo SunZoo = new Zoo("Sun's World", "Da Nang");

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				SunZooApplication.class)) {
						// Add dummy Cage1
			SunZoo.addCage(new Cage(200, new ArrayList<Animal>(List.of(new Lion("the King", 10)))));
			// Add dummy Cage2
			SunZoo.addCage(new Cage(150, new ArrayList<Animal>(
					List.of(new Dolphin("dolphin the eve", 10), new Lion("The chuppy Lion", 3)))));
			// Add dummy Cage3
			SunZoo.addCage(new Cage(110, new ArrayList<Animal>(List.of(new Lion("the cup", 10)))));
			// Add dummy Cage4
			SunZoo.addCage(new Cage(220, new ArrayList<Animal>(List.of(new Dolphin("the smart day", 10)))));
			
			// Scanners
			Scanner scanner = new Scanner(System.in);
			Scanner scannerForAddCage = new Scanner(System.in);
			int initialChoice;

			// Process
			do {
				System.out.println("WelCome to SunWord's Zoo:\nWhat do you want to do\n1. Login\n2. Sign up\n3. Exit");
				initialChoice = scanner.nextInt();

				switch (initialChoice) {
				case 1: {
					System.out.print("WelCome to SunWord's Zoo:\nEnter your account: ");
					String account = scanner.next();
					System.out.print("Enter your password: ");
					String pwd = scanner.next();

					// Check type of account
					if (account.equals("admin") && pwd.equals(pwd)) {
						int adminChoice;
						do {
							System.out.println("****Welcom to SunWorldZoo****\nAdministration task");
							System.out.println("1. Check Zoo's Information");
							System.out.println("2. AddCage");
							System.out.println("3. Add animal to cage");
							System.out.println("4. Quit");
							adminChoice = scanner.nextInt();
							switch (adminChoice) {
							case 1: {
								System.out.println(SunZoo.toString());
								break;
							}
							case 2: {
								System.out.print("Insert price: ");
								int addedPrice = scanner.nextInt();
								int addedAnimalChoice;
								ArrayList<Animal> addedCageAnimal = new ArrayList<>();
								// ArrayList<String> addedAnimalList = new ArrayList<String>();
								do {
									System.out.println("What kind of animals:");
									System.out.println("1. Lion");
									System.out.println("2. Dolphin");
									System.out.println("3. I'm done.");
									addedAnimalChoice = scannerForAddCage.nextInt();

									final int Lion = 1;
									final int Dolphin = 2;

									switch (addedAnimalChoice) {
									case Lion: {
										System.out.print("Enter lion's name: ");
										String lionName = scanner.next();
										System.out.print("Enter lion's age:");
										int age = scanner.nextInt();
										addedCageAnimal.add(new Lion(lionName, age));
										break;
									}
									case Dolphin: {
										System.out.println("Enter dolphin's name: ");
										String dolphinName = scanner.next();
										System.out.print("Enter dolphin's age:");
										int age = scanner.nextInt();
										addedCageAnimal.add(new Dolphin(dolphinName, age));
										break;
									}
									}
								} while (addedAnimalChoice != 3);
								// Process's follow: check array size, if there is just 1, and if just two, we
								// hard coded this into 2 patter, only1 animal, and if 2, that must be 1 lion

								// Process's follow: we don't hard-code anything, we add animal to a List, and
								// then use cage constructor to generate addedCage and then add that cage into

								// and
								// 1 dolphin
								// if (addedAnimalList.size() >= 2) {
								//// SunZoo.addCage(new Cage(addedPrice, new ArrayList<Animal>(List
								//// .of(new Lion("Added lion by switch case", 10), new Dolphin("dolphin added
								// by SC", 2)))));
								// for (String animal : addedAnimalList) {
								// if (animal.toLowerCase().equals("lion")) {
								// addedCage.add(new Lion("abc", 10));
								// } else if (animal.toLowerCase().equals("dolphin")) {
								// addedCage.add(new Dolphin("abc", 10));
								// }
								// }
								// } else if (addedAnimalList.size() == 1) {
								// for (String addedAnimal : addedAnimalList) {
								// if (addedAnimal.toLowerCase().equals("lion")) {
								// SunZoo.addCage(new Cage(addedPrice,
								// new ArrayList<Animal>(List.of(new Lion("Added lion by switch case", 10)))));
								// } else
								// SunZoo.addCage(new Cage(addedPrice,
								// new ArrayList<Animal>(List.of(new Dolphin("Added dolphin by switch case",
								// 3)))));
								// }
								// }

								// Process's follow: we don't hard-code anything, we add animal to a List, and
								// then use cage constructor to generate addedcage and then add that cage into

								// Zoo via zoo.addCage function
								SunZoo.addCage(new Cage(addedPrice, addedCageAnimal));
								break;
							}
							case 3: {
								System.out.print("Enter specific cage: ");
								int selectedCageNumber = scanner.nextInt();
								Cage selectedCage = SunZoo.getCages().get(selectedCageNumber - 1);


//								ArrayList<Animal> addedCageAnimal = new ArrayList<>();
								int addedAnimalChoice;
								// ArrayList<String> addedAnimalList = new ArrayList<String>();

								do {
									System.out.println("What kind of animals:");
									System.out.println("1. Lion");
									System.out.println("2. Dolphin");
									System.out.println("3. I'm done.");
									addedAnimalChoice = scanner.nextInt();

									final int Lion = 1;
									final int Dolphin = 2;

									// Switch case to add animal into addedCageAnimal;
									switch (addedAnimalChoice) {
									case Lion: {
										System.out.print("Enter lion's name: ");
										String lionName = scanner.next();
										System.out.print("Enter lion's age:");
										int lionAge = scanner.nextInt();
										selectedCage.addAnimal(new Lion(lionName, lionAge));
										break;
									}
									case Dolphin: {
										System.out.println("Enter dolphin's name: ");
										String dolphinName = scanner.next();
										System.out.print("Enter dolphin's age:");
										int dolphinAge = scanner.nextInt();
										selectedCage.addAnimal(new Dolphin(dolphinName, dolphinAge));
										break;
									}
									}
								} while (addedAnimalChoice != 3);

							}
							}
						} while (adminChoice != 4);
					}

					// Retrieve Account from DB
					ArrayList<Account> accountArr = context.getBean(AccountJdbcRepository.class).findAllAcc();
					System.out.println(accountArr);
					Boolean accountExistFlag = false;


					// Check authority

					for (Account acc : accountArr) {
						if (acc.getAccount().equals(account) && acc.getPwd().equals(pwd)) {
							accountExistFlag = true;
							break;
						}
					}
					if (accountExistFlag) {
						int visitorChoice;
						do {
							System.out.println("****Welcom to SunWorldZoo****\nWhat do you want to do.");
							System.out.println("1. Visit.");
							System.out.println("2. Exit console.");
							visitorChoice = scanner.nextInt();

							switch (visitorChoice) {
							case 1: {
								System.out.println("Choose cage to vist");
								int visitedCage = scanner.nextInt();
								
								final int justVisit = 1;
								final int visitAndAction = 2;
								
								System.out.println("Do you want to just vist or action\n1. Just visit\n2. Visit and take action");
								int visitOrVisitAndAction = scanner.nextInt();
								

								int cageAmount = SunZoo.getCages().size();
								//Check if choose cage within cage amount
								if (visitedCage <= cageAmount) {
									switch (visitOrVisitAndAction) {
									case justVisit: {

										SunZoo.visit(visitedCage);
										break;
									}
									case visitAndAction: {
										System.out.println(
												"Choose action:\n1. Visit and Touch\n2. Visit and taking a ride");
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
								}else
								{
									throw new IndexOutOfBoundsException("Out of cages, please input within: " + cageAmount);
								}
								

							}
							}

						} while (visitorChoice != 2);

					} else
						System.out.println("Invalid account");
					break;

				}
				case 2: {
					System.out.print("Please enter sign up account: ");
					String signupAccount = scanner.next();
					System.out.print("Please enter sign up pwd: ");
					String signupPwd = scanner.next();
					Account signedupAccount = new Account(signupAccount, signupPwd);

					// Add account to Account table

					context.getBean(AccountJdbcRepository.class).insertAccount(signedupAccount);
					break;
				}
				}

			} while (initialChoice != 3);

			// Close scanners
			scanner.close();
			scannerForAddCage.close();

		} catch (BeansException e) {
			e.printStackTrace();

		}

	}

}
