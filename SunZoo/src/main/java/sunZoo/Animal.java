package sunZoo;

import action.Action;

public interface Animal {
	void bark();

	String getName();

	void minusHealthAfterVisited();

	String toString();

	int getHealth();

	void plusHealthAfterFeeded();

	void minusHealthAfterAction(Action action);

	void barkWhenGetTouched();

	void setHealthToZeroWhenRiden();

	void barkWhenGetRiden();

	String getType();
	
	int getAge();

}
