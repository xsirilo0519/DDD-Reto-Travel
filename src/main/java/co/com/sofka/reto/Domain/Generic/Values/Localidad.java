package co.com.sofka.reto.Domain.Generic.Values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Localidad implements ValueObject<String> {
    private final String value;
    public Localidad(String value) {
        this.value = Objects.requireNonNull(value);
    }
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Localidad localidad = (Localidad) o;
        return Objects.equals(value, localidad.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
