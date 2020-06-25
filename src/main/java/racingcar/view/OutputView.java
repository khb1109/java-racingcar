package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.car.info.Name;

public class OutputView {
	private static final String GAGE = "-";
	private static final String DELIMITER = ", ";
	private static final String EMPTY = "";

	public void resultText() {
		System.out.println("실행 결과");
	}

	public void racingState(Cars cars) {
		for (Car car : cars.getCars()) {
			System.out.printf("%s : %s\n", car.getName().getName(), collectDistance(car));
		}
		System.out.println();
	}

	public void racingWinner(List<Name> winners) {
		System.out.printf("%s가 최종 우승했습니다.",
			winners.stream()
				.map(Name::getName)
				.collect(Collectors.joining(DELIMITER))
		);
	}

	private String collectDistance(Car car) {
		return IntStream.range(0, car.getPosition())
			.mapToObj(num -> GAGE)
			.collect(Collectors.joining(EMPTY));
	}
}
