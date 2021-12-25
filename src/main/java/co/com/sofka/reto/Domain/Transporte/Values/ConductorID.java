package co.com.sofka.reto.Domain.Transporte.Values;

import co.com.sofka.domain.generic.Identity;

public class ConductorID extends Identity {
    public ConductorID() {

    }

    private ConductorID(String id) {
        super(id);
    }

    public static ConductorID of(String id) {
        return new ConductorID(id);

    }
}
