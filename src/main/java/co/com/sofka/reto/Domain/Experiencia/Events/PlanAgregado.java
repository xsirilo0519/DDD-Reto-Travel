package co.com.sofka.reto.Domain.Experiencia.Events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Experiencia.Values.PlanID;
import co.com.sofka.reto.Domain.Generic.Values.Descripcion;

public class PlanAgregado extends DomainEvent {
    private final PlanID planID;
    private final Descripcion descripcion;

    public PlanAgregado(PlanID planID, Descripcion descripcion) {
        super("sofka.experiencia.PlanAgregado");
        this.planID=planID;
        this.descripcion=descripcion;
    }

    public PlanID getPlanID() {
        return planID;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
