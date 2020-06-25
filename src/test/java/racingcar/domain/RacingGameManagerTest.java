package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.car.info.Name;

class RacingGameManagerTest {
	private RacingGameManager racingGameManager;

	@BeforeEach
	void setUp() {
		Car allen = CarHelper.create("allen", 5);
		Car pobi = CarHelper.create("pobi", 5);
		Car woni = CarHelper.create("woni", 3);
		Car brown = CarHelper.create("brown", 3);
		Cars cars = new Cars(Arrays.asList(allen, pobi, woni, brown), () -> false);

		RacingCount racingCount = new RacingCount(3);

		racingGameManager = new RacingGameManager(cars, racingCount);
	}

	@DisplayName("Car의 승자의 이름을 구한다.")
	@Test
	void findWinners() {
		List<Name> winners = racingGameManager.findWinners();

		assertThat(winners).contains(new Name("allen"), new Name("pobi"));
	}

	@DisplayName("레이싱게임 중인지 확인한다.")
	@Test
	void isRunning() {
		assertThat(racingGameManager.isRunning()).isTrue();
	}

	@DisplayName("경주를 진행하여 몇번 째 게임인지 확인한다.")
	@Test
	void next() {
		racingGameManager.nextRacing();
		assertThat(racingGameManager.getRunningCount()).isEqualTo(1);
	}
}