package co.com.sofka.reto.Domain.Generic.Values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Locacion implements ValueObject<String> {
    private final String value;
    public Locacion(String value) {
        this.value = Objects.requireNonNull(value);
    }
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Locacion locacion = (Locacion) o;
        return Objects.equals(value, locacion.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
