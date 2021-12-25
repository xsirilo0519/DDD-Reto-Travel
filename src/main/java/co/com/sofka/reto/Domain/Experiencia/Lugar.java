package co.com.sofka.reto.Domain.Experiencia;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.reto.Domain.Experiencia.Values.Locacion;
import co.com.sofka.reto.Domain.Experiencia.Values.LugarID;
import co.com.sofka.reto.Domain.Experiencia.Values.Rango;

import java.util.Objects;

public class Lugar extends Entity<LugarID> {
    private Rango rango;
    private Locacion locacion;

    public Lugar(LugarID lugarID, Rango rango, Locacion locacion){
    super(lugarID);
    this.rango=rango;
    this.locacion=locacion;
}

public void actualizarRango(Rango rango){
        this.rango= Objects.requireNonNull(rango);
}
public void actualizarLocacion(Locacion locacion){
        this.locacion=Objects.requireNonNull(locacion);
}

    public Rango rango() {
        return rango;
    }

    public Locacion locacion() {
        return locacion;
    }
}
