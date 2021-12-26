package co.com.sofka.reto.Domain.Transporte.Events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Generic.Values.Email;
import co.com.sofka.reto.Domain.Transporte.Values.ResponsableID;

public class EmailResponsableActualizado extends DomainEvent {
    private final ResponsableID responsableID;
    private final Email email;
    public EmailResponsableActualizado(ResponsableID responsableID, Email email) {
        super("sofka.transporte.EmailResponsableActualizado");
        this.responsableID=responsableID;
        this.email=email;
    }

    public ResponsableID getResponsableID() {
        return responsableID;
    }

    public Email getEmail() {
        return email;
    }
}
