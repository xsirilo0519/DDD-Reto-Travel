package co.com.sofka.reto.Domain.Hotel;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.reto.Domain.Generic.Values.Descripcion;
import co.com.sofka.reto.Domain.Hotel.Values.ActividadID;

import java.util.Objects;

public class Actividad extends Entity<ActividadID> {
    private Descripcion descripcion;
    public Actividad(ActividadID actividadID,Descripcion descripcion){
        super(actividadID);
        this.descripcion=descripcion;
    }

    public void actualizarDescripcion(Descripcion descripcion){
        this.descripcion= Objects.requireNonNull(descripcion);
    }

    public Descripcion descripcion() {
        return descripcion;
    }
}
