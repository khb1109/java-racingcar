package racingcar.controller;

import static java.util.stream.Collectors.*;

import java.util.Collections;
import java.util.List;

import racingcar.domain.RacingCount;
import racingcar.domain.RacingGameManager;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.car.info.Name;
import racingcar.domain.car.info.strategy.NumberStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
	private final NumberStrategy numberStrategy;
	private final InputView inputView;
	private final OutputView outputView;

	public RacingGameController(NumberStrategy numberStrategy, InputView inputView,
		OutputView outputView) {
		this.numberStrategy = numberStrategy;
		this.inputView = inputView;
		this.outputView = outputView;
	}

	public void run() {
		List<Name> names = receiveNames();
		Cars cars = createCars(names, numberStrategy);
		RacingCount racingCount = receiveCount();

		RacingGameManager racingGameManager = new RacingGameManager(cars, racingCount);

		outputView.resultText();
		while (racingGameManager.isRunning()) {
			racingGameManager.nextRacing();
			outputView.racingState(cars);
		}

		outputView.racingWinner(racingGameManager.findWinners());
	}

	private List<Name> receiveNames() {
		return inputView.names()
			.stream()
			.map(Name::new)
			.collect(collectingAndThen(toList(), Collections::unmodifiableList));
	}

	private Cars createCars(List<Name> names, NumberStrategy numberStrategy) {
		return names.stream()
			.map(Car::new)
			.collect(collectingAndThen(toList(), cars -> new Cars(cars, numberStrategy)));
	}

	private RacingCount receiveCount() {
		return new RacingCount(inputView.count());
	}
}
