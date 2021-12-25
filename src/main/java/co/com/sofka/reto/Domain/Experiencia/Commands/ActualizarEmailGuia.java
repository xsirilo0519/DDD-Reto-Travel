package co.com.sofka.reto.Domain.Experiencia.Commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Experiencia.Values.ExperienciaID;
import co.com.sofka.reto.Domain.Experiencia.Values.GuiaID;
import co.com.sofka.reto.Domain.Generic.Values.Email;

public class ActualizarEmailGuia extends Command {
    private final ExperienciaID experienciaID;
    private final GuiaID guiaID;
    private final Email email;
    public ActualizarEmailGuia(ExperienciaID experienciaID,GuiaID guiaID, Email email) {
        this.experienciaID=experienciaID;
        this.guiaID=guiaID;
        this.email=email;
    }

    public ExperienciaID getExperienciaID() {
        return experienciaID;
    }

    public GuiaID getGuiaID() {
        return guiaID;
    }

    public Email getEmail() {
        return email;
    }
}
