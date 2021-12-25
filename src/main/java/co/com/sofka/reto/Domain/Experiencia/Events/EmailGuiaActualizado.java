package co.com.sofka.reto.Domain.Experiencia.Events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Experiencia.Values.GuiaID;
import co.com.sofka.reto.Domain.Generic.Values.Email;

public class EmailGuiaActualizado extends DomainEvent {
    private final GuiaID guiaID;
    private final Email email;
    public EmailGuiaActualizado(GuiaID guiaID, Email email) {
        super("sofka.experiencia.EmailGuiaActualizado");
        this.guiaID=guiaID;
        this.email=email;
    }

    public GuiaID getGuiaID() {
        return guiaID;
    }

    public Email getEmail() {
        return email;
    }
}
