package co.com.sofka.reto.Domain.Transporte.Events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Generic.Values.Email;
import co.com.sofka.reto.Domain.Transporte.Values.ConductorID;

public class EmailConductorActualizado extends DomainEvent {
    private final ConductorID conductorID;
    private final Email email;
    public EmailConductorActualizado(ConductorID conductorID, Email email) {
        super("sofka.transporte.EmailConductorActualizado");
        this.conductorID=conductorID;
        this.email=email;
    }

    public ConductorID getConductorID() {
        return conductorID;
    }

    public Email getEmail() {
        return email;
    }
}
