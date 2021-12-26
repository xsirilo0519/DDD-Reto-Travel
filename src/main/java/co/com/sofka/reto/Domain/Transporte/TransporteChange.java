package co.com.sofka.reto.Domain.Transporte;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.reto.Domain.Hotel.Events.RecreacionistaAgregado;
import co.com.sofka.reto.Domain.Hotel.Recreacionista;
import co.com.sofka.reto.Domain.Transporte.Events.*;

public class TransporteChange extends EventChange {
    public TransporteChange(Transporte transporte){
        apply((TransporteCreado event)->{
            transporte.descripcion=event.getDescripcion();
        });

        apply((CapacidadVehiculoActualizada event)->{
            transporte.vehiculo.actualizarCapacidad(event.getCapacidad());
        });

        apply((ConductorAgregado event)->{
            transporte.conductor=new Conductor(event.getConductorID(),event.getNombre(),event.getLocalidad(),event.getEmail(),event.getTelefono());
        });

        apply((ResponsableAgregado event)->{
            transporte.responsable=new Responsable(event.getResponsableID(),event.getNombre(),event.getLocalidad(),event.getEmail(),event.getTelefono());
        });

        apply((EmailConductorActualizado event)->{
            transporte.conductor.actualizarEmail(event.getEmail());
        });

        apply((EmailResponsableActualizado event)->{
            transporte.responsable.actualizarEmail(event.getEmail());
        });

        apply((LocalidadConductorActualizada event)->{
            transporte.conductor.actualizarLocalidad(event.getLocalidad());
        });

        apply((LocalidadResponsableActualizada event)->{
            transporte.responsable.actualizarLocalidad(event.getLocalidad());
        });

        apply((TelefonoConductorActualizado event)->{
             transporte.conductor.actualizarTelefono(event.getTelefono());
         });

        apply((TelefonoResponsableActualizado event)->{
            transporte.responsable.actualizarTelefono(event.getTelefono());
        });

        apply((VehiculoAgregado event)->{
            transporte.vehiculo=new Vehiculo(event.getPlaca(),event.getModelo(),event.getCapacidad());
        });
    }
}
