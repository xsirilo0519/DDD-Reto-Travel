package co.com.sofka.reto.Domain.Hotel.Values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Estado implements ValueObject<Boolean> {
    private final Boolean value;

    public Estado(Boolean value) {
        this.value = Objects.requireNonNull(value);
    }
    public Boolean value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estado estado = (Estado) o;
        return Objects.equals(value, estado.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
