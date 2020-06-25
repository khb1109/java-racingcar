package racingcar.domain.car.info.strategy;

import java.util.Random;

public class RandomNumberStrategy implements NumberStrategy {
	private static final Random random = new Random();
	private static final int RANDOM_NUMBER_RANGE = 10;
	private static final int ASCENDING_CONDITION = 5;

	@Override
	public boolean canMove() {
		return random.nextInt(RANDOM_NUMBER_RANGE) >= ASCENDING_CONDITION;
	}
}
