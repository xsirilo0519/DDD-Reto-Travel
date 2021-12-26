package co.com.sofka.reto.Domain.Transporte.Commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.Domain.Generic.Values.Email;
import co.com.sofka.reto.Domain.Generic.Values.Localidad;
import co.com.sofka.reto.Domain.Generic.Values.Nombre;
import co.com.sofka.reto.Domain.Generic.Values.Telefono;
import co.com.sofka.reto.Domain.Transporte.Values.ResponsableID;
import co.com.sofka.reto.Domain.Transporte.Values.TransporteID;

public class AgregarResponsable extends Command {
    private final TransporteID transporteID;
    private final ResponsableID responsableID;
    private final Nombre nombre;
    private final Telefono telefono;
    private final Email email;
    private final Localidad localidad;
    public AgregarResponsable(TransporteID transporteID, ResponsableID responsableID, Nombre nombre, Telefono telefono, Email email, Localidad localidad) {
        this.transporteID=transporteID;
        this.responsableID=responsableID;
        this.nombre=nombre;
        this.telefono=telefono;
        this.email=email;
        this.localidad=localidad;
    }

    public TransporteID getTransporteID() {
        return transporteID;
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
