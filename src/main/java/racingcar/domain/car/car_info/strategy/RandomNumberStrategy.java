package racingcar.domain.car.car_info.strategy;

import java.util.Random;

public class RandomNumberStrategy implements NumberStrategy {
	private static final Random random = new Random();
	private static final int RANDOM_NUMBER_RANGE = 10;

	@Override
	public int createValue() {
		return random.nextInt(RANDOM_NUMBER_RANGE);
	}
}
