package sunZoo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.SunZoo.SunZoo.account.Account;

import action.Action;
import action.TakeARide;
import action.Touch;

@Component
public class Cage {
	// Attribute
	static int number = 1;
	private int No;
	private ArrayList<Animal> animals = new ArrayList<Animal>();
	private int price;
	private int hygiene;
	private boolean isAvailable = true;
	// Actions

	private static Action touch = new Touch();
	private static Action takeARide = new TakeARide();
	private static Action[] action = { touch, takeARide };

	// Constructor

	public Cage(int price, ArrayList<Animal> animal) {
		this.price = price;
		this.hygiene = 5; // The initial hygiene is always 5
		this.animals = animal;
		this.No = Cage.number;

	}

	// Behavior

	public void addAnimal(Animal animal) {
		this.animals.add(animal);

	}

//	public ArrayList<Action> getAction() {
//		return action;
//	}

	public int getPrice() {
		return price;
	}

	public Action[] getAction() {
		return action;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNo() {
		return No;
	}

	public void setNo(int no) {
		No = no;
	}

	public ArrayList<Animal> getAnimals() {
		return animals;
	}

	public void setAnimals(ArrayList<Animal> animals) {
		this.animals = animals;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;

	}

	public int getHygiene() {
		return hygiene;
	}

	public void setHygiene(int hygiene) {
		this.hygiene = hygiene;
	}

	public String toString() {
		return String.format(
				"This is cage No.%d, It cost %d$ to visit.\nAnimals status:\n %s\nHygine: %d\nAction: %s \n", No, price,
				animals.toString(), hygiene, action.toString());
	}

}
