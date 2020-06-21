package racingcar.domain;

import racingcar.domain.car.Car;
import racingcar.domain.car.car_info.Name;

public class CarProvider {
	public static Car create(String name, int position) {
		return new Car(new Name(name), position);
	}
}
