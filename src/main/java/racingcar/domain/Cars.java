package racingcar.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {
	private static final int MIN_RACER_NUMBER = 2;
	private final List<Car> cars;
	private final NumberStrategy numberStrategy;

	public Cars(List<Car> cars, NumberStrategy numberStrategy) throws IllegalAccessException {
		validate(cars, numberStrategy);
		this.cars = cars;
		this.numberStrategy = numberStrategy;
	}

	private void validate(List<Car> cars, NumberStrategy numberStrategy) throws IllegalAccessException {
		Objects.requireNonNull(numberStrategy);
		Objects.requireNonNull(cars);
		if (cars.size() < MIN_RACER_NUMBER) {
			throw new IllegalAccessException("주행할 차량이 없습니다.");
		}
	}

	public List<Name> findWinners() {
		Car maxPositionCar = cars.stream()
			.max(Car::compareTo)
			.orElseThrow(() -> new IllegalStateException("최대 값을 찾을 수 없습니다."));

		return cars.stream()
			.filter(car -> car.isSamePosition(maxPositionCar))
			.map(Car::getName)
			.collect(Collectors.toList());
	}

	public void doRacing() {
		cars.forEach(car -> car.move(numberStrategy));
	}

	public List<Car> getCars() {
		return cars;
	}
}