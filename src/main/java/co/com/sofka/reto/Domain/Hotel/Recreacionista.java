package co.com.sofka.reto.Domain.Hotel;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.reto.Domain.Experiencia.Values.GuiaID;
import co.com.sofka.reto.Domain.Generic.Values.Email;
import co.com.sofka.reto.Domain.Generic.Values.Localidad;
import co.com.sofka.reto.Domain.Generic.Values.Nombre;
import co.com.sofka.reto.Domain.Generic.Values.Telefono;
import co.com.sofka.reto.Domain.Hotel.Values.RecreacionistaID;

import java.util.Objects;

public class Recreacionista extends Entity<RecreacionistaID> {
    private final Nombre nombre;
    private Localidad localidad;
    private Email email;
    private Telefono telefono;
    public Recreacionista(RecreacionistaID recreacionistaID, Nombre nombre, Localidad localidad, Email email, Telefono telefono) {
        super(recreacionistaID);
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
