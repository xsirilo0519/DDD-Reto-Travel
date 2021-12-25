package co.com.sofka.reto.Domain.Generic.Values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Descripcion  implements ValueObject<String> {
    private final String value;
    public Descripcion(String value) {
        this.value = Objects.requireNonNull(value);
    }
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Descripcion that = (Descripcion) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
