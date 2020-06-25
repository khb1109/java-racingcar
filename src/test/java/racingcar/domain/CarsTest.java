package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.car.info.Name;

class CarsTest {
	private static Stream<Arguments> carProvider() {
		return Stream.of(
			Arguments.of(
				Arrays.asList(CarHelper.create("allen", 5))
			), Arguments.of(
				IntStream.range(0, 11)
					.mapToObj(num -> CarHelper.create("allen", 5))
					.collect(Collectors.toList())
			)
		);
	}

	@DisplayName("차들은 2대이상, 10대 이하다.")
	@MethodSource("carProvider")
	@ParameterizedTest
	void name(List<Car> cars) {
		assertThatThrownBy(() -> new Cars(cars, () -> true))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("Car의 승자의 이름을 구한다.")
	@Test
	void findWinners() {
		Car allen = CarHelper.create("allen", 5);
		Car pobi = CarHelper.create("pobi", 5);
		Car woni = CarHelper.create("woni", 3);
		Car brown = CarHelper.create("brown", 3);
		Cars cars = new Cars(Arrays.asList(allen, pobi, woni, brown), () -> true);

		assertThat(cars.findWinners()).contains(new Name("allen"), new Name("pobi"));
	}

	@DisplayName("자동차들을 경주시켜 조건에 맞게 이동시킨다.")
	@Test
	void doRacing() {
		Car allen = CarHelper.create("allen", 5);
		Car pobi = CarHelper.create("allen", 5);
		Cars cars = new Cars(Arrays.asList(allen, pobi), () -> true);

		cars.race();

		assertThat(allen.isSamePosition(6)).isTrue();
	}
}