package co.com.sofka.reto.Domain.Hotel.Events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Generic.Values.Email;
import co.com.sofka.reto.Domain.Hotel.Values.RecreacionistaID;

public class EmailRecreacionistaActualizado extends DomainEvent {
    private final RecreacionistaID recreacionistaID;
    private final Email email;
    public EmailRecreacionistaActualizado(RecreacionistaID recreacionistaID, Email email) {
        super("sofka.hotel.EmailRecreacionistaActualizado");
        this.recreacionistaID=recreacionistaID;
        this.email=email;
    }

    public RecreacionistaID getRecreacionistaID() {
        return recreacionistaID;
    }

    public Email getEmail() {
        return email;
    }
}
