package co.com.sofka.reto.Domain.Transporte.Commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.Domain.Generic.Values.Localidad;
import co.com.sofka.reto.Domain.Transporte.Values.ConductorID;
import co.com.sofka.reto.Domain.Transporte.Values.TransporteID;

public class ActualizarLocalidadConductor extends Command {
    private final TransporteID transporteID;
    private final ConductorID conductorID;
    private final Localidad localidad;
    public ActualizarLocalidadConductor(TransporteID transporteID, ConductorID conductorID, Localidad localidad) {
        this.transporteID=transporteID;
        this.localidad=localidad;
        this.conductorID=conductorID;
    }

    public TransporteID getTransporteID() {
        return transporteID;
    }

    public ConductorID getConductorID() {
        return conductorID;
    }

    public Localidad getLocalidad() {
        return localidad;
    }
}
