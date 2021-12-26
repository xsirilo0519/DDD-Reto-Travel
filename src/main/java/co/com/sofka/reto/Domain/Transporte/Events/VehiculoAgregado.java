package co.com.sofka.reto.Domain.Transporte.Events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Transporte.Values.Capacidad;
import co.com.sofka.reto.Domain.Transporte.Values.Modelo;
import co.com.sofka.reto.Domain.Transporte.Values.Placa;

public class VehiculoAgregado extends DomainEvent {
    private final Placa placa;
    private final Capacidad capacidad;
    private final Modelo modelo;
    public VehiculoAgregado(Placa placa, Capacidad capacidad, Modelo modelo) {
        super("sofka.transporte.VehiculoAgregado");
        this.placa=placa;
        this.capacidad=capacidad;
        this.modelo=modelo;
    }

    public Placa getPlaca() {
        return placa;
    }

    public Capacidad getCapacidad() {
        return capacidad;
    }

    public Modelo getModelo() {
        return modelo;
    }
}
