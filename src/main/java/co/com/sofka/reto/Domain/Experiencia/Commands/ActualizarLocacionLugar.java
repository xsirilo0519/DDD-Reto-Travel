package co.com.sofka.reto.Domain.Experiencia.Commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Experiencia.Values.ExperienciaID;
import co.com.sofka.reto.Domain.Experiencia.Values.Locacion;
import co.com.sofka.reto.Domain.Experiencia.Values.LugarID;

public class ActualizarLocacionLugar extends Command {
    private final ExperienciaID experienciaID;
    private final LugarID lugarID;
    private final Locacion locacion;
    public ActualizarLocacionLugar(ExperienciaID experienciaID,LugarID lugarID, Locacion locacion) {
        this.experienciaID=experienciaID;
        this.lugarID=lugarID;
        this.locacion=locacion;
    }

    public ExperienciaID getExperienciaID() {
        return experienciaID;
    }

    public LugarID getLugarID() {
        return lugarID;
    }

    public Locacion getLocacion() {
        return locacion;
    }
}
