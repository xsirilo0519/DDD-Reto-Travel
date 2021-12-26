package co.com.sofka.reto.Domain.Transporte.Commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Transporte.Values.Capacidad;
import co.com.sofka.reto.Domain.Transporte.Values.Modelo;
import co.com.sofka.reto.Domain.Transporte.Values.Placa;
import co.com.sofka.reto.Domain.Transporte.Values.TransporteID;

public class AgregarVehiculo extends Command {
    private final TransporteID transporteID;
    private final Placa placa;
    private final Capacidad capacidad;
    private final Modelo modelo;
    public AgregarVehiculo(TransporteID transporteID,Placa placa, Capacidad capacidad, Modelo modelo) {
        this.transporteID=transporteID;
        this.placa=placa;
        this.capacidad=capacidad;
        this.modelo=modelo;
    }

    public TransporteID getTransporteID() {
        return transporteID;
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
