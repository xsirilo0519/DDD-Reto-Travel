package co.com.sofka.reto.Domain.Transporte.Commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.Domain.Transporte.Values.Capacidad;
import co.com.sofka.reto.Domain.Transporte.Values.Placa;
import co.com.sofka.reto.Domain.Transporte.Values.TransporteID;

public class ActualizarCapacidadVehiculo extends Command {
    private final TransporteID transporteID;
    private final Placa placa;
    private final Capacidad capacidad;
    public ActualizarCapacidadVehiculo(TransporteID transporteID, Placa placa, Capacidad capacidad) {
        this.transporteID=transporteID;
        this.placa=placa;
        this.capacidad=capacidad;
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
}
