package co.com.sofka.reto.Domain.Transporte.Commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Generic.Values.Email;
import co.com.sofka.reto.Domain.Transporte.Values.ConductorID;
import co.com.sofka.reto.Domain.Transporte.Values.TransporteID;

public class ActualizarEmailConductor extends Command {
    private final TransporteID transporteID;
    private final ConductorID conductorID;
    private final Email email;
    public ActualizarEmailConductor(TransporteID transporteID,ConductorID conductorID, Email email) {
        this.transporteID=transporteID;
        this.conductorID=conductorID;
        this.email=email;
    }

    public TransporteID getTransporteID() {
        return transporteID;
    }

    public ConductorID getConductorID() {
        return conductorID;
    }

    public Email getEmail() {
        return email;
    }
}
