package co.com.sofka.reto.Domain.Transporte.Commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Generic.Values.Descripcion;
import co.com.sofka.reto.Domain.Transporte.Values.TransporteID;

public class CrearTransporte extends Command {
    private final TransporteID transporteID;
    private final Descripcion descripcion;

    public CrearTransporte(TransporteID transporteID,Descripcion descripcion) {
        this.transporteID=transporteID;
        this.descripcion=descripcion;
    }

    public TransporteID getTransporteID() {
        return transporteID;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
