package racingcar.domain.car.info;

public class RacingNameException extends RuntimeException {
	public static final String LENGTH_MESSAGE = "잘못된 이름입니다. name=";

	public RacingNameException() {
	}

	public RacingNameException(String message) {
		super(message);
	}
}
