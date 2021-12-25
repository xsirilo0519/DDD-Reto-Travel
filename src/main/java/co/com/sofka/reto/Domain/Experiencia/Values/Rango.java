package co.com.sofka.reto.Domain.Experiencia.Values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Rango implements ValueObject<String> {
    private final String value;
    public Rango(String value) {
        this.value = Objects.requireNonNull(value);
    }
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rango rango = (Rango) o;
        return Objects.equals(value, rango.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
