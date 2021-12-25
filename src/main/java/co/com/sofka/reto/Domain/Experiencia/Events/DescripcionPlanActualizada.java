package co.com.sofka.reto.Domain.Experiencia.Events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Experiencia.Values.PlanID;
import co.com.sofka.reto.Domain.Generic.Values.Descripcion;

public class DescripcionPlanActualizada extends DomainEvent {

    private final PlanID planID;
    private final Descripcion descripcion;

    public DescripcionPlanActualizada(PlanID planID, Descripcion descripcion) {
        super("sofka.experiencia.DescripcionPlanActualizada");
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
