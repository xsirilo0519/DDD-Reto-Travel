package co.com.sofka.reto.Domain.Experiencia.Values;

import co.com.sofka.domain.generic.Identity;

public class GuiaID extends Identity {

    public GuiaID() {

    }

    private GuiaID(String id) {
        super(id);
    }

    public static GuiaID of(String id) {
        return new GuiaID(id);

    }

}
