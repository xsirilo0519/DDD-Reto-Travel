package co.com.sofka.reto.Domain.Transporte.Commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Generic.Values.Telefono;
import co.com.sofka.reto.Domain.Transporte.Values.ResponsableID;
import co.com.sofka.reto.Domain.Transporte.Values.TransporteID;

public class ActualizarTelefonoResponsable extends Command {
    private final TransporteID transporteID;
    private final ResponsableID responsableID;
    private final Telefono telefono;
    public ActualizarTelefonoResponsable(TransporteID transporteID,ResponsableID responsableID, Telefono telefono) {
        this.transporteID=transporteID;
        this.responsableID=responsableID;
        this.telefono=telefono;
    }

    public TransporteID getTransporteID() {
        return transporteID;
    }

    public ResponsableID getResponsableID() {
        return responsableID;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
