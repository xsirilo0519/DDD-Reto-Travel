package co.com.sofka.reto.Domain.Transporte.Values;

import co.com.sofka.domain.generic.Identity;

public class ResponsableID extends Identity {
    public ResponsableID() {

    }

    private ResponsableID(String id) {
        super(id);
    }

    public static ResponsableID of(String id) {
        return new ResponsableID(id);

    }
}
