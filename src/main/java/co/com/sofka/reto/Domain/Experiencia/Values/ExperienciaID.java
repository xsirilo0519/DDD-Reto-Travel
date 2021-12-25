package co.com.sofka.reto.Domain.Experiencia.Values;

import co.com.sofka.domain.generic.Identity;

public class ExperienciaID extends Identity {
    public ExperienciaID() {

    }

    private ExperienciaID(String id) {
        super(id);
    }

    public static ExperienciaID of(String id) {
        return new ExperienciaID(id);

    }
}
