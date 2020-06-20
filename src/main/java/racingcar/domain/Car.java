package racingcar.domain;

import java.util.Objects;

public class Car {
	private static final int ASCENDING_CONDITION = 5;
	private final Name userName;
	private int position;

	public Car(Name userName) {
		Objects.requireNonNull(userName);
		this.userName = userName;
		this.position = 0;
	}

	public void move(NumberStrategy numberStrategy) {
		if (numberStrategy.createValue() >= ASCENDING_CONDITION) {
			this.position++;
		}
	}

	public boolean isSamePosition(int position) {
		return this.position == position;
	}

	public Name getUserName() {
		return userName;
	}

	public int getPosition() {
		return position;
	}
}
