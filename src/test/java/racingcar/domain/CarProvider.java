package racingcar.domain;

public class CarProvider {
	public static Car create(String name, int position) {
		return new Car(new Name(name), position);
	}
}
