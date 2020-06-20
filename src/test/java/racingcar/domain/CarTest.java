package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {
	@DisplayName("값이 5이상이면 한칸 이동한다.")
	@CsvSource(value = {"5,1", "4,0"})
	@ParameterizedTest
	void name(int value, int expect) {
		Car car = new Car(new Name("allen"));

		car.move(() -> value);

		assertThat(car.isSamePosition(expect)).isTrue();
	}
}
