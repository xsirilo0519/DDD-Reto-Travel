package co.com.sofka.reto.Domain.Transporte.Commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.Domain.Generic.Values.Email;
import co.com.sofka.reto.Domain.Generic.Values.Localidad;
import co.com.sofka.reto.Domain.Generic.Values.Nombre;
import co.com.sofka.reto.Domain.Generic.Values.Telefono;
import co.com.sofka.reto.Domain.Transporte.Values.ConductorID;
import co.com.sofka.reto.Domain.Transporte.Values.TransporteID;

public class AgregarConductor extends Command {
    private final TransporteID transporteID;
    private final ConductorID conductorID;
    private final Nombre nombre;
    private final Telefono telefono;
    private final Email email;
    private final Localidad localidad;
    public AgregarConductor(TransporteID transporteID, ConductorID conductorID, Nombre nombre, Telefono telefono, Email email, Localidad localidad) {
        this.transporteID=transporteID;
        this.conductorID=conductorID;
        this.nombre=nombre;
        this.telefono=telefono;
        this.email=email;
        this.localidad=localidad;
    }

    public TransporteID getTransporteID() {
        return transporteID;
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
