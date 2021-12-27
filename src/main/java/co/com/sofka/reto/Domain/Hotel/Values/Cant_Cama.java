package co.com.sofka.reto.Domain.Hotel.Values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Cant_Cama implements ValueObject<Integer> {
    private final Integer value;
    public Cant_Cama(Integer value) {
        this.value = Objects.requireNonNull(value);
    }
    public Integer value() {
        if (value<0) {
            throw new IllegalArgumentException("El telefono no puede ser negativo");
        }
            return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cant_Cama cant_cama = (Cant_Cama) o;
        return Objects.equals(value, cant_cama.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
