package racingcar.domain;

import racingcar.domain.car.Car;
import racingcar.domain.car.info.Name;

public class CarHelper {
	public static Car create(String name, int position) {
		return new Car(new Name(name), position);
	}
}
