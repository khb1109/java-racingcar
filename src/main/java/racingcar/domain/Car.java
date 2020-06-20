package racingcar.domain;

import java.util.Objects;

public class Car implements Comparable<Car> {
	private static final int ASCENDING_CONDITION = 5;
	private final Name userName;
	private int position;

	public Car(Name userName) {
		this(userName, 0);
	}

	public Car(Name userName, int position) {
		Objects.requireNonNull(userName);
		this.userName = userName;
		this.position = position;
	}

	public void move(NumberStrategy numberStrategy) {
		if (numberStrategy.createValue() >= ASCENDING_CONDITION) {
			this.position++;
		}
	}

	public boolean isSamePosition(int position) {
		return this.position == position;
	}

	@Override
	public int compareTo(Car other) {
		return Integer.compare(this.position, other.position);
	}

	public Name getUserName() {
		return userName;
	}

	public int getPosition() {
		return position;
	}
}
