package racingcar.domain.car;

import java.util.Objects;

import racingcar.domain.car.info.Name;
import racingcar.domain.car.info.strategy.NumberStrategy;

public class Car implements Comparable<Car> {
	private static final int ASCENDING_CONDITION = 5;

	private final Name name;
	private int position;

	public Car(Name name) {
		this(name, 0);
	}

	public Car(Name name, int position) {
		Objects.requireNonNull(name);
		this.name = name;
		this.position = position;
	}

	public void move(NumberStrategy numberStrategy) {
		if (numberStrategy.canMove()) {
			this.position++;
		}
	}

	public boolean isSamePosition(int position) {
		return this.position == position;
	}

	public boolean isSamePosition(Car other) {
		Objects.requireNonNull(other);
		return this.position == other.position;
	}

	@Override
	public int compareTo(Car other) {
		Objects.requireNonNull(other);
		return Integer.compare(this.position, other.position);
	}

	public Name getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}
}
