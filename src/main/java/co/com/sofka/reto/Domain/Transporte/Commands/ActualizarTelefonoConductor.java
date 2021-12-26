package co.com.sofka.reto.Domain.Transporte.Commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Generic.Values.Telefono;
import co.com.sofka.reto.Domain.Transporte.Values.ConductorID;
import co.com.sofka.reto.Domain.Transporte.Values.TransporteID;

public class ActualizarTelefonoConductor extends Command {
    private final TransporteID transporteID;
    private final ConductorID conductorID;
    private final Telefono telefono;
    public ActualizarTelefonoConductor(TransporteID transporteID,ConductorID conductorID, Telefono telefono) {
        this.transporteID=transporteID;
        this.conductorID=conductorID;
        this.telefono=telefono;
    }

    public TransporteID getTransporteID() {
        return transporteID;
    }

    public ConductorID getConductorID() {
        return conductorID;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
