package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import racingcar.domain.car.Car;
import racingcar.domain.car.info.Name;

class CarTest {
	@DisplayName("자동차는 이동규칙이 맞으면 한칸 이동한다.")
	@CsvSource(value = {"true,1", "false,0"})
	@ParameterizedTest
	void name(boolean canMove, int expect) {
		Car car = new Car(new Name("allen"));

		car.move(() -> canMove);

		assertThat(car.isSamePosition(expect)).isTrue();
	}

	@DisplayName("Car의 이름은 null이 올 수 없다.")
	@Test
	void name() {
		assertThatThrownBy(() -> new Car(null))
			.isInstanceOf(NullPointerException.class);
	}

	@DisplayName("Car의 포지션이 같은지 확인한다.")
	@Test
	void name2() {
		int expect = 5;

		Car car = new Car(new Name("allen"), expect);

		assertThat(car.isSamePosition(expect)).isTrue();
	}

	@DisplayName("Car와 다른 Car의 포지션이 같은지 확인한다.")
	@Test
	void name6() {
		int expect = 5;

		Car car = new Car(new Name("allen"), expect);
		Car other = new Car(new Name("pobi"), expect);

		assertThat(car.isSamePosition(other)).isTrue();
	}

	@DisplayName("두개의 Car의 Position을 비교한다.")
	@CsvSource(value = {"5,4,1", "4,5,-1", "5,5,0"})
	@ParameterizedTest
	void name3(int aPosition, int bPosition, int result) {
		Car aCar = new Car(new Name("allen"), aPosition);
		Car bCar = new Car(new Name("allen"), bPosition);

		assertThat(aCar.compareTo(bCar)).isEqualTo(result);
	}
}
