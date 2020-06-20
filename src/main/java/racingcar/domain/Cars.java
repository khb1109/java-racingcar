package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
	private final List<Car> cars;
	private final NumberStrategy numberStrategy;

	public Cars(List<Car> cars, NumberStrategy numberStrategy) {
		this.cars = cars;
		this.numberStrategy = numberStrategy;
	}

	public List<Car> getCars() {
		return cars;
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
}
