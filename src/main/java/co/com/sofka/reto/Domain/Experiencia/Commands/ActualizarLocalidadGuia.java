package co.com.sofka.reto.Domain.Experiencia.Commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Experiencia.Values.ExperienciaID;
import co.com.sofka.reto.Domain.Experiencia.Values.GuiaID;
import co.com.sofka.reto.Domain.Generic.Values.Localidad;

public class ActualizarLocalidadGuia extends Command {
    private final ExperienciaID experienciaID;
    private final GuiaID guiaID;
    private final Localidad localidad;
    public ActualizarLocalidadGuia(ExperienciaID experienciaID,GuiaID guiaID, Localidad localidad) {
        this.experienciaID=experienciaID;
        this.guiaID=guiaID;
        this.localidad=localidad;
    }

    public ExperienciaID getExperienciaID() {
        return experienciaID;
    }

    public GuiaID getGuiaID() {
        return guiaID;
    }

    public Localidad getLocalidad() {
        return localidad;
    }
}
