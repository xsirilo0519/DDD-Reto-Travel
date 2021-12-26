package co.com.sofka.reto.Domain.Transporte.Commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.Domain.Generic.Values.Localidad;
import co.com.sofka.reto.Domain.Transporte.Values.ResponsableID;
import co.com.sofka.reto.Domain.Transporte.Values.TransporteID;

public class ActualizarLocalidadResponsable extends Command {
    private final TransporteID transporteID;
    private final ResponsableID responsableID;
    private final Localidad localidad;
    public ActualizarLocalidadResponsable(TransporteID transporteID, ResponsableID responsableID, Localidad localidad) {
        this.transporteID=transporteID;
        this.responsableID=responsableID;
        this.localidad=localidad;
    }

    public TransporteID getTransporteID() {
        return transporteID;
    }

    public ResponsableID getResponsableID() {
        return responsableID;
    }

    public Localidad getLocalidad() {
        return localidad;
    }
}
