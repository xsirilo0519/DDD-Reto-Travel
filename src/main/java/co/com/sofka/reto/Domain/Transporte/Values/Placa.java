package co.com.sofka.reto.Domain.Transporte.Values;

import co.com.sofka.domain.generic.Identity;

public class Placa extends Identity {
    public Placa() {

    }

    private Placa(String id) {
        super(id);
    }

    public static Placa of(String id) {
        return new Placa(id);

    }
}
