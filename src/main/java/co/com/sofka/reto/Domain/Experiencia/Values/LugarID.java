package co.com.sofka.reto.Domain.Experiencia.Values;

import co.com.sofka.domain.generic.Identity;

public class LugarID extends Identity {
    public LugarID() {

    }

    private LugarID(String id) {
        super(id);
    }

    public static LugarID of(String id) {
        return new LugarID(id);

    }
}
