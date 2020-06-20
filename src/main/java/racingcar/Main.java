package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.domain.RandomNumberStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Main {
	public static void main(String[] args) {
		new RacingGameController(new RandomNumberStrategy(), new InputView(), new OutputView())
			.run();
	}
}
