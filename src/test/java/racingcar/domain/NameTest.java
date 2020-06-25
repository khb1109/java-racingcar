package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static racingcar.domain.car.info.RacingNameException.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.domain.car.info.Name;
import racingcar.domain.car.info.RacingNameException;

class NameTest {
	@DisplayName("이름을 생성한다")
	@Test
	void constructor() {
		String expect = "김홍빈";

		Name actual = new Name(expect);

		assertThat(actual.getName()).isEqualTo(expect);
	}

	@DisplayName("이름은 1자 이상, 5자 이하로 구성된다")
	@EmptySource
	@ValueSource(strings = {"김홍빈김광순", "김        광"})
	@ParameterizedTest
	void checkNameLength(String name) {
		assertThatThrownBy(() -> new Name(name))
			.isInstanceOf(RacingNameException.class)
			.hasMessage("잘못된 이름입니다. name=" + name);
	}

	@DisplayName("이름은 빈 문자열로만 이루어질 수 없다")
	@ValueSource(strings = {"  ", "                 ", "\t\t\t"})
	@ParameterizedTest
	void checkNameOnlyEmpty(String name) {
		assertThatThrownBy(() -> new Name(name))
			.isInstanceOf(RacingNameException.class)
			.hasMessageContaining(LENGTH_MESSAGE);
	}

	@DisplayName("문자 앞, 뒤로 오는 공백 문자는 무시한다")
	@CsvSource(value = {"     앨런,앨런", "알트     ,알트", "   히로   ,히로"})
	@ParameterizedTest
	void checkTrimmedName(String name, String actual) {
		Name expect = new Name(name);

		assertThat(expect.getName()).isEqualTo(actual);
	}

	@DisplayName("입력값이 null인 경우 예외가 발생한다")
	@NullSource
	@ParameterizedTest
	void checkNull(String name) {
		assertThatThrownBy(() -> new Name(name))
			.isInstanceOf(NullPointerException.class);
	}
}
