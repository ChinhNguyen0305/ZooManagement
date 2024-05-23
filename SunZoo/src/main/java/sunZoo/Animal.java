package sunZoo;

import action.Action;

public abstract class Animal {
	public abstract void bark();

	public abstract String getName();

	public abstract void minusHealthAfterVisited();

	public abstract String toString();

	public abstract int getHealth();

	public abstract void plusHealthAfterFeeded();

	public abstract void minusHealthAfterAction(Action action);

	public abstract void barkWhenGetTouched();

	public abstract void setHealthToZeroWhenRiden();

	public abstract void barkWhenGetRiden();

	public abstract String getType();
	
	public abstract int getAge();

}
