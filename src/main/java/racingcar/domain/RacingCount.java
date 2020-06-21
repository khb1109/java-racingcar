package racingcar.domain;

import static racingcar.domain.InvalidRacingCountException.*;

public class RacingCount {
	private static final int MIN_COUNT = 1;
	private static final int MAX_COUNT = 10;

	private final int amount;

	public RacingCount(int amount) {
		validate(amount);
		this.amount = amount;
	}

	private void validate(int amount) {
		if (amount < MIN_COUNT || amount > MAX_COUNT) {
			throw new InvalidRacingCountException(MESSAGE + amount);
		}
	}

	public boolean isSameCount(int runningCount) {
		return this.amount == runningCount;
	}
}
