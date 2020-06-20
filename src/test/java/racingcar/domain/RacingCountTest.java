package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingCountTest {
	@DisplayName("게임은 1 ~ 10 사이의 정수이다.")
	@ValueSource(ints = {0, 11})
	@ParameterizedTest
	void name(int badNumber) {
		assertThatThrownBy(() -> new RacingCount(badNumber))
			.isInstanceOf(InvalidRacingCountException.class);
	}
}