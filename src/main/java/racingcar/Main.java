package racingcar;

import java.util.logging.Level;
import java.util.logging.Logger;

import racingcar.controller.RacingGameController;
import racingcar.domain.car.info.strategy.RandomNumberStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Main {
	private static final Logger logger = Logger.getLogger("logger");

	public static void main(String[] args) {
		try {
			new RacingGameController(new RandomNumberStrategy(), new InputView(), new OutputView())
				.run();
		} catch (RuntimeException e) {
			logger.log(Level.WARNING, e.getMessage());
			System.out.println("잘못된 입력입니다.");
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage());
			System.out.println("오류가 발생했습니다.");
		}
	}
}
