package racingcar.domain;

public class InvalidRacingCountException extends RuntimeException {
	public static final String MESSAGE = "유효하지 않는 범위입니다.";

	public InvalidRacingCountException() {
	}

	public InvalidRacingCountException(String message) {
		super(message);
	}
}
