package co.com.sofka.reto.Domain.Experiencia.Commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Experiencia.Values.ExperienciaID;
import co.com.sofka.reto.Domain.Experiencia.Values.Locacion;
import co.com.sofka.reto.Domain.Experiencia.Values.LugarID;
import co.com.sofka.reto.Domain.Experiencia.Values.Rango;

public class AgregarLugar extends Command {
    private final ExperienciaID experienciaID;
    private final LugarID lugarID;
    private final Rango rango;
    private final Locacion locacion;
    public AgregarLugar(ExperienciaID experienciaID,LugarID lugarID, Rango rango, Locacion locacion) {
        this.experienciaID=experienciaID;
        this.locacion=locacion;
        this.rango=rango;
        this.lugarID=lugarID;
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

    public Locacion getLocacion() {
        return locacion;
    }
}
