package co.com.sofka.reto.Domain.Transporte.Values;

import co.com.sofka.domain.generic.Identity;

public class TransporteID extends Identity {
    public TransporteID() {

    }

    private TransporteID(String id) {
        super(id);
    }

    public static TransporteID of(String id) {
        return new TransporteID(id);

    }
}
