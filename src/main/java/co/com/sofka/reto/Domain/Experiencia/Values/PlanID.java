package co.com.sofka.reto.Domain.Experiencia.Values;

import co.com.sofka.domain.generic.Identity;

public class PlanID extends Identity {
    public PlanID() {

    }

    private PlanID(String id) {
        super(id);
    }

    public static PlanID of(String id) {
        return new PlanID(id);

    }
}
