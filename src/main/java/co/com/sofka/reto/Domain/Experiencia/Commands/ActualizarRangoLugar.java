package co.com.sofka.reto.Domain.Experiencia.Commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Experiencia.Values.ExperienciaID;
import co.com.sofka.reto.Domain.Experiencia.Values.LugarID;
import co.com.sofka.reto.Domain.Experiencia.Values.Rango;

public class ActualizarRangoLugar extends Command {
    private final ExperienciaID experienciaID;
    private final LugarID lugarID;
    private final Rango rango;
    public ActualizarRangoLugar(ExperienciaID experienciaID,LugarID lugarID, Rango rango) {
        this.experienciaID=experienciaID;
        this.lugarID=lugarID;
        this.rango=rango;
    }

    public ExperienciaID getExperienciaID() {
        return experienciaID;
    }

    public LugarID getLugarID() {
        return lugarID;
    }

    public Rango getRango() {
        return rango;
    }
}
