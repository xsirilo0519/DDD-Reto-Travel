package co.com.sofka.reto.Domain.Experiencia;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.reto.Domain.Experiencia.Values.PlanID;
import co.com.sofka.reto.Domain.Generic.Values.Descripcion;

import java.util.Objects;

public class Plan extends Entity<PlanID> {
    private Descripcion descripcion;
    public Plan(PlanID planID,Descripcion descripcion){
        super(planID);
        this.descripcion=descripcion;
    }

    public void actualizarDescripcion(Descripcion descripcion){
        this.descripcion= Objects.requireNonNull(descripcion);
    }

    public Descripcion descripcion() {
        return descripcion;
    }
}
