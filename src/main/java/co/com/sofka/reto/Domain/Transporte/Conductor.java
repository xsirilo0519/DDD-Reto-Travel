package co.com.sofka.reto.Domain.Transporte;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.reto.Domain.Generic.Values.Email;
import co.com.sofka.reto.Domain.Generic.Values.Localidad;
import co.com.sofka.reto.Domain.Generic.Values.Nombre;
import co.com.sofka.reto.Domain.Generic.Values.Telefono;
import co.com.sofka.reto.Domain.Transporte.Values.ConductorID;
import co.com.sofka.reto.Domain.Transporte.Values.ResponsableID;

import java.util.Objects;

public class Conductor extends Entity<ConductorID> {
    private final Nombre nombre;
    private Localidad localidad;
    private Email email;
    private Telefono telefono;
    public Conductor(ConductorID conductorID, Nombre nombre, Localidad localidad, Email email, Telefono telefono) {
        super(conductorID);
        this.nombre=nombre;
        this.localidad=localidad;
        this.email=email;
        this.telefono=telefono;
    }

    public void actualizarLocalidad(Localidad localidad){
        this.localidad= Objects.requireNonNull(localidad);
    }

    public void actualizarEmail(Email email){
        this.email= Objects.requireNonNull(email);
    }

    public void actualizarTelefono(Telefono telefono){
        this.telefono= Objects.requireNonNull(telefono);
    }

    public Nombre nombre() {
        return nombre;
    }

    public Localidad localidad() {
        return localidad;
    }

    public Email email() {
        return email;
    }

    public Telefono telefono() {
        return telefono;
    }
}
