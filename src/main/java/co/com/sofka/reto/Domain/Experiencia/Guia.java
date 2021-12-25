package co.com.sofka.reto.Domain.Experiencia;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.reto.Domain.Experiencia.Values.GuiaID;
import co.com.sofka.reto.Domain.Generic.Values.Email;
import co.com.sofka.reto.Domain.Generic.Values.Localidad;
import co.com.sofka.reto.Domain.Generic.Values.Nombre;
import co.com.sofka.reto.Domain.Generic.Values.Telefono;

import java.util.Objects;

public class Guia extends Entity<GuiaID> {
    private Nombre nombre;
    private Localidad localidad;
    private Email email;
    private Telefono telefono;
    public Guia(GuiaID guiaID, Nombre nombre, Localidad localidad, Email email,Telefono telefono) {
        super(guiaID);
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
