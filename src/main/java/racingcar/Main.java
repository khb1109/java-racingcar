package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.domain.RandomNumberStrategy;

public class Main {
	public static void main(String[] args) {
		new RacingGameController(new RandomNumberStrategy())
			.run();
	}
}
