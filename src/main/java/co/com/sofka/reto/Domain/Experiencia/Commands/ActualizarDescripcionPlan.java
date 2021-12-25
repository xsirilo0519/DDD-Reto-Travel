package co.com.sofka.reto.Domain.Experiencia.Commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Experiencia.Values.ExperienciaID;
import co.com.sofka.reto.Domain.Experiencia.Values.PlanID;
import co.com.sofka.reto.Domain.Generic.Values.Descripcion;

public class ActualizarDescripcionPlan extends Command {

    private final ExperienciaID experienciaID;
    private final PlanID planID;
    private final Descripcion descripcion;

    public ActualizarDescripcionPlan(ExperienciaID experienciaID,PlanID planID, Descripcion descripcion) {
        this.experienciaID=experienciaID;
        this.planID=planID;
        this.descripcion=descripcion;
    }

    public ExperienciaID getExperienciaID() {
        return experienciaID;
    }

    public PlanID getPlanID() {
        return planID;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
