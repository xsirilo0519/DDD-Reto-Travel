package co.com.sofka.reto.Domain.Transporte.Commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Generic.Values.Email;
import co.com.sofka.reto.Domain.Transporte.Values.ResponsableID;
import co.com.sofka.reto.Domain.Transporte.Values.TransporteID;

public class ActualizarEmailResponsable extends Command {
    private final TransporteID transporteID;
    private final ResponsableID responsableID;
    private final Email email;
    public ActualizarEmailResponsable(TransporteID transporteID,ResponsableID responsableID, Email email) {
        this.transporteID=transporteID;
        this.responsableID=responsableID;
        this.email=email;
    }

    public TransporteID getTransporteID() {
        return transporteID;
    }

    public ResponsableID getResponsableID() {
        return responsableID;
    }

    public Email getEmail() {
        return email;
    }
}
