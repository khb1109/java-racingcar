package racingcar.domain.car;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import racingcar.domain.car.info.Name;
import racingcar.domain.car.info.strategy.NumberStrategy;

public class Cars {
	private static final int MIN_RACER_NUMBER = 2;
	private static final int MAX_RACER_COUNT = 10;

	private final List<Car> cars;
	private final NumberStrategy numberStrategy;

	public Cars(List<Car> cars, NumberStrategy numberStrategy) {
		validate(cars, numberStrategy);
		this.cars = cars;
		this.numberStrategy = numberStrategy;
	}

	private void validate(List<Car> cars, NumberStrategy numberStrategy) {
		Objects.requireNonNull(numberStrategy);
		Objects.requireNonNull(cars);
		if (cars.size() < MIN_RACER_NUMBER || cars.size() > MAX_RACER_COUNT) {
			throw new IllegalArgumentException("잘못된 인원수를 잘못 입력했습니다. cars.size()=" + cars.size());
		}
	}

	public List<Name> findWinners() {
		Car maxPositionCar = findMaxPositionCar();
		return findSamePositionCars(maxPositionCar);
	}

	public void race() {
		cars.forEach(car -> car.move(numberStrategy));
	}

	private List<Name> findSamePositionCars(Car maxPositionCar) {
		return cars.stream()
			.filter(car -> car.isSamePosition(maxPositionCar))
			.map(Car::getName)
			.collect(Collectors.toList());
	}

	private Car findMaxPositionCar() {
		return cars.stream()
			.max(Car::compareTo)
			.orElseThrow(() -> new IllegalStateException("최대 값을 찾을 수 없습니다."));
	}

	public List<Car> getCars() {
		return Collections.unmodifiableList(cars);
	}
}
