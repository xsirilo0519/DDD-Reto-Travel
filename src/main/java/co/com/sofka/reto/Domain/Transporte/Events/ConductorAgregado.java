package co.com.sofka.reto.Domain.Transporte.Events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Generic.Values.Email;
import co.com.sofka.reto.Domain.Generic.Values.Localidad;
import co.com.sofka.reto.Domain.Generic.Values.Nombre;
import co.com.sofka.reto.Domain.Generic.Values.Telefono;
import co.com.sofka.reto.Domain.Hotel.Values.RecreacionistaID;
import co.com.sofka.reto.Domain.Transporte.Values.ConductorID;

public class ConductorAgregado extends DomainEvent {
    private final ConductorID conductorID;
    private final Nombre nombre;
    private final Telefono telefono;
    private final Email email;
    private final Localidad localidad;
    public ConductorAgregado(ConductorID conductorID, Nombre nombre, Telefono telefono, Email email, Localidad localidad) {
        super("sofka.transporte.ConductorAgregado");
        this.conductorID=conductorID;
        this.nombre=nombre;
        this.telefono=telefono;
        this.email=email;
        this.localidad=localidad;
    }

    public ConductorID getConductorID() {
        return conductorID;
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
