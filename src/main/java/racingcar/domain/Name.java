package racingcar.domain;

import java.util.Objects;

public class Name {
	private static final int MIN_NAME_LENGTH = 1;
	private static final int MAX_NAME_LENGTH = 5;
	private final String name;

	public Name(final String name) {
		final String trimmedName = name.trim();
		validateName(trimmedName);
		this.name = trimmedName;
	}

	private void validateName(final String name) {
		Objects.requireNonNull(name);
		validateLength(name);
	}

	private void validateLength(final String name) {
		if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
			throw new RacingNameException(RacingNameException.LENGTH_MESSAGE + name);
		}
	}

	public String getName() {
		return name;
	}
}
