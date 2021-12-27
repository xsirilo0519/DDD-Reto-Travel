package co.com.sofka.reto.Domain.Generic.Values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Telefono implements ValueObject<Double> {
    private final Double value;
    public Telefono(Double value) {
        if (value<0){
            throw new IllegalArgumentException("El telefono no puede ser negativo");
        }
        this.value = Objects.requireNonNull(value);
    }
    public Double value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telefono telefono = (Telefono) o;
        return Objects.equals(value, telefono.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
