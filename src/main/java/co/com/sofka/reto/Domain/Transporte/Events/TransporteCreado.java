package co.com.sofka.reto.Domain.Transporte.Events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Generic.Values.Descripcion;

public class TransporteCreado extends DomainEvent {

    private final Descripcion descripcion;

    public TransporteCreado(Descripcion descripcion) {
        super("sofka.transporte.TransporteCreado");
        this.descripcion=descripcion;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
