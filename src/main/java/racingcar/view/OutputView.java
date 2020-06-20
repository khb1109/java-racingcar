package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import racingcar.domain.Car;

public class OutputView {
	private static final java.lang.String STRING = "-";

	public void resultText() {
		System.out.println("실행 결과");
	}

	public void racingState(List<Car> cars) {
		for (Car car : cars) {
			System.out.printf("%s : %s\n", car.getUserName().getName(), collectDistance(car));
		}
	}

	private String collectDistance(Car car) {
		return IntStream.of(car.getPosition())
			.mapToObj(x -> STRING)
			.collect(Collectors.joining(""));
	}
}
