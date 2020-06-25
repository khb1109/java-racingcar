package racingcar.domain;

import java.util.List;

import racingcar.domain.car.Cars;
import racingcar.domain.car.info.Name;

public class RacingGameManager {
	private final Cars cars;
	private final RacingCount racingCount;
	private int runningCount;

	public RacingGameManager(Cars cars, RacingCount racingCount) {
		this.cars = cars;
		this.racingCount = racingCount;
		this.runningCount = 0;
	}

	public List<Name> findWinners() {
		return cars.findWinners();
	}

	public boolean isRunning() {
		return !racingCount.isSameCount(runningCount);
	}

	public void nextRacing() {
		cars.race();
		this.runningCount++;
	}

	public int getRunningCount() {
		return runningCount;
	}
}
