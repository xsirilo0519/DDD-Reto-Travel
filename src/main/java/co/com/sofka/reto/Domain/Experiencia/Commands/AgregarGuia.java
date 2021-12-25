package co.com.sofka.reto.Domain.Experiencia.Commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Experiencia.Values.ExperienciaID;
import co.com.sofka.reto.Domain.Experiencia.Values.GuiaID;
import co.com.sofka.reto.Domain.Generic.Values.Email;
import co.com.sofka.reto.Domain.Generic.Values.Localidad;
import co.com.sofka.reto.Domain.Generic.Values.Nombre;
import co.com.sofka.reto.Domain.Generic.Values.Telefono;

public class AgregarGuia extends Command {
    private final ExperienciaID experienciaID;
    private final GuiaID guiaID;
    private final Nombre nombre;
    private final Telefono telefono;
    private final Email email;
    private final Localidad localidad;

    public AgregarGuia(ExperienciaID experienciaID,GuiaID guiaID, Nombre nombre, Telefono telefono, Email email, Localidad localidad) {
        this.experienciaID=experienciaID;
        this.guiaID=guiaID;
        this.nombre=nombre;
        this.telefono=telefono;
        this.email=email;
        this.localidad=localidad;
    }

    public ExperienciaID getExperienciaID() {
        return experienciaID;
    }

    public GuiaID getGuiaID() {
        return guiaID;
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
