package co.com.sofka.reto.Domain.Hotel.Events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Generic.Values.Descripcion;
import co.com.sofka.reto.Domain.Hotel.Values.ActividadID;

public class ActividadAgregada extends DomainEvent {
    private final ActividadID actividadID;
    private final Descripcion descripcion;
    public ActividadAgregada(ActividadID actividadID, Descripcion descripcion) {
        super("sofka.hotel.ActividadAgregada");
        this.actividadID=actividadID;
        this.descripcion=descripcion;
    }

    public ActividadID getActividadID() {
        return actividadID;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
