package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class RacingCountTest {
	@DisplayName("게임은 1 ~ 10 사이의 정수이다.")
	@ValueSource(ints = {0, 11})
	@ParameterizedTest
	void name(int badNumber) {
		assertThatThrownBy(() -> new RacingCount(badNumber))
			.isInstanceOf(InvalidRacingCountException.class);
	}

	@DisplayName("카운트가 같은지 확인한다.")
	@CsvSource(value = {"5,5,true", "5,4,false"})
	@ParameterizedTest
	void isSameCount(int racingCount, int other, boolean expect) {
		RacingCount actual = new RacingCount(racingCount);
		assertThat(actual.isSameCount(other)).isEqualTo(expect);
	}
}