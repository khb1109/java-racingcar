package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Name;

public class OutputView {
	private static final java.lang.String STRING = "-";
	private static final String DELIMITER = ", ";

	public void resultText() {
		System.out.println("실행 결과");
	}

	public void racingState(Cars cars) {
		for (Car car : cars.getCars()) {
			System.out.printf("%s : %s\n", car.getName().getName(), collectDistance(car));
		}
	}

	public void racingWinner(List<Name> winners) {
		System.out.printf("%s가 최종 우승했습니다.",
			winners.stream()
				.map(Name::getName)
				.collect(Collectors.joining(DELIMITER))
		);
	}

	private String collectDistance(Car car) {
		return IntStream.of(car.getPosition())
			.mapToObj(x -> STRING)
			.collect(Collectors.joining(""));
	}
}
