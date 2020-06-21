package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.car.car_info.Name;

class CarsTest {
	private static final int ASCENDING_NUMBER = 5;

	@DisplayName("Car의 승자의 이름을 구한다.")
	@Test
	void findWinners() {
		Car allen = CarProvider.create("allen", 5);
		Car pobi = CarProvider.create("pobi", 5);
		Car woni = CarProvider.create("woni", 3);
		Car brown = CarProvider.create("brown", 3);
		Cars cars = new Cars(Arrays.asList(allen, pobi, woni, brown), () -> 0);

		assertThat(cars.findWinners()).contains(new Name("allen"), new Name("pobi"));
	}

	@DisplayName("자동차들을 경주시켜 조건에 맞게 이동시킨다.")
	@Test
	void doRacing() {
		Car allen = CarProvider.create("allen", 5);
		Car pobi = CarProvider.create("allen", 5);
		Cars cars = new Cars(Arrays.asList(allen, pobi), () -> ASCENDING_NUMBER);

		cars.doRacing();

		assertThat(allen.isSamePosition(6)).isTrue();
	}
}