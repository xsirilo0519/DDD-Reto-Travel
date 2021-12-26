package co.com.sofka.reto.Domain.Transporte.Events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Transporte.Values.Capacidad;
import co.com.sofka.reto.Domain.Transporte.Values.Placa;

public class CapacidadVehiculoActualizada extends DomainEvent {
    private final Placa placa;
    private final Capacidad capacidad;
    public CapacidadVehiculoActualizada(Placa placa, Capacidad capacidad) {
        super("sofka.transporte.CapacidadVehiculoActualizada");
        this.placa=placa;
        this.capacidad=capacidad;
    }

    public Placa getPlaca() {
        return placa;
    }

    public Capacidad getCapacidad() {
        return capacidad;
    }
}
