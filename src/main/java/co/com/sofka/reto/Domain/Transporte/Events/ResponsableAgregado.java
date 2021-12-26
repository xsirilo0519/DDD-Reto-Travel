package co.com.sofka.reto.Domain.Transporte.Events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Generic.Values.Email;
import co.com.sofka.reto.Domain.Generic.Values.Localidad;
import co.com.sofka.reto.Domain.Generic.Values.Nombre;
import co.com.sofka.reto.Domain.Generic.Values.Telefono;
import co.com.sofka.reto.Domain.Transporte.Values.ConductorID;
import co.com.sofka.reto.Domain.Transporte.Values.ResponsableID;

public class ResponsableAgregado extends DomainEvent {
    private final ResponsableID responsableID;
    private final Nombre nombre;
    private final Telefono telefono;
    private final Email email;
    private final Localidad localidad;
    public ResponsableAgregado(ResponsableID responsableID, Nombre nombre, Telefono telefono, Email email, Localidad localidad) {
        super("sofka.transporte.ResponsableAgregado");
        this.responsableID=responsableID;
        this.nombre=nombre;
        this.telefono=telefono;
        this.email=email;
        this.localidad=localidad;
    }

    public ResponsableID getResponsableID() {
        return responsableID;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public Email getEmail() {
        return email;
    }

    public Localidad getLocalidad() {
        return localidad;
    }
}
