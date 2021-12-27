package co.com.sofka.reto.Domain.Generic.Values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Nombre implements ValueObject<String> {
    private final String value;
    public Nombre(String value) {

        if (!value.matches("^[\\p{L} .'-]+$")){
            throw new IllegalArgumentException("El nombre debe contener solo letras");
        }
        this.value = Objects.requireNonNull(value);
    }
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nombre nombre = (Nombre) o;
        return Objects.equals(value, nombre.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
