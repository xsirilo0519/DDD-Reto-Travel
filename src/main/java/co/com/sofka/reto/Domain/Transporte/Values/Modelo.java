package co.com.sofka.reto.Domain.Transporte.Values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Modelo implements ValueObject<Integer> {

    private final Integer value;
    public Modelo(Integer value) {
        this.value = Objects.requireNonNull(value);
    }
    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Modelo modelo = (Modelo) o;
        return Objects.equals(value, modelo.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
