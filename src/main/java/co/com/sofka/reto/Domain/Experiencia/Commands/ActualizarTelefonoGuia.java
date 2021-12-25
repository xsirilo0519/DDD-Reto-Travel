package co.com.sofka.reto.Domain.Experiencia.Commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Experiencia.Values.ExperienciaID;
import co.com.sofka.reto.Domain.Experiencia.Values.GuiaID;
import co.com.sofka.reto.Domain.Generic.Values.Telefono;

public class ActualizarTelefonoGuia extends Command {
    private final ExperienciaID experienciaID;
    private final GuiaID guiaID;
    private final Telefono telefono;
    public ActualizarTelefonoGuia(ExperienciaID experienciaID,GuiaID guiaID, Telefono telefono) {
        this.experienciaID=experienciaID;
        this.guiaID=guiaID;
        this.telefono=telefono;
    }

    public ExperienciaID getExperienciaID() {
        return experienciaID;
    }

    public GuiaID getGuiaID() {
        return guiaID;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
