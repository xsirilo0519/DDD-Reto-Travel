package co.com.sofka.reto.Domain.Hotel.Values;

import co.com.sofka.domain.generic.Identity;
import co.com.sofka.reto.Domain.Experiencia.Values.PlanID;

public class ActividadID extends Identity {
    public ActividadID() {

    }

    private ActividadID(String id) {
        super(id);
    }

    public static ActividadID of(String id) {
        return new ActividadID(id);

    }
}
