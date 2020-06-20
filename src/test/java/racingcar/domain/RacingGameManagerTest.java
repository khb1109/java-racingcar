package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameManagerTest {
	private RacingGameManager racingGameManager;

	@BeforeEach
	void setUp() {
		Car allen = CarProvider.create("allen", 5);
		Car pobi = CarProvider.create("pobi", 5);
		Car woni = CarProvider.create("woni", 3);
		Car brown = CarProvider.create("brown", 3);
		Cars cars = new Cars(Arrays.asList(allen, pobi, woni, brown), () -> 0);

		RacingCount racingCount = new RacingCount(3);

		racingGameManager = new RacingGameManager(cars, racingCount);
	}

	@DisplayName("Car의 승자의 이름을 구한다.")
	@Test
	void findWinners() {
		List<Name> winners = racingGameManager.findWinners();

		assertThat(winners).contains(new Name("allen"), new Name("pobi"));
	}

	@Test
	void isRunning() {
		assertThat(racingGameManager.isRunning()).isTrue();
	}

	@Test
	void next() {
		racingGameManager.nextRacing();
		assertThat(racingGameManager.getRunningCount()).isEqualTo(1);
	}
}