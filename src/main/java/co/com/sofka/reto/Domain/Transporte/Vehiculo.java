package co.com.sofka.reto.Domain.Transporte;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.reto.Domain.Transporte.Values.Capacidad;
import co.com.sofka.reto.Domain.Transporte.Values.Modelo;
import co.com.sofka.reto.Domain.Transporte.Values.Placa;

import java.util.Objects;

public class Vehiculo extends Entity<Placa> {

    private Modelo modelo;
    private Capacidad capacidad;

    public Vehiculo (Placa placa,Modelo modelo,Capacidad capacidad){
    super(placa);
    this.capacidad=capacidad;
    this.modelo=modelo;
    }

    public void actualizarCapacidad(Capacidad capacidad){
        this.capacidad= Objects.requireNonNull(capacidad);
    }

    public Modelo modelo() {
        return modelo;
    }

    public Capacidad capacidad() {
        return capacidad;
    }
}
