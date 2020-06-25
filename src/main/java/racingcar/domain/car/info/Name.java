package racingcar.domain.car.info;

import java.util.Objects;

public class Name {
	private static final int MIN_NAME_LENGTH = 1;
	private static final int MAX_NAME_LENGTH = 5;

	private final String name;

	public Name(String name) {
		Objects.requireNonNull(name);
		final String trimmedName = name.trim();
		validateName(trimmedName);
		this.name = trimmedName;
	}

	private void validateName(String name) {
		validateLength(name);
	}

	private void validateLength(String name) {
		if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
			throw new RacingNameException(RacingNameException.LENGTH_MESSAGE + name);
		}
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Name name1 = (Name)o;
		return Objects.equals(getName(), name1.getName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getName());
	}
}
