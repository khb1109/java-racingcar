package racingcar.domain;

import java.util.List;

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
		cars.doRacing();
		this.runningCount++;
	}

	public int getRunningCount() {
		return runningCount;
	}
}
