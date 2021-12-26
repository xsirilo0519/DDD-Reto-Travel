package co.com.sofka.reto.Domain.Experiencia;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.reto.Domain.Experiencia.Events.*;

public class ExperienciaChange extends EventChange {
    public ExperienciaChange(Experiencia experiencia){
        apply((ExperienciaCreada event)->{
            experiencia.precio=event.getPrecio();
            experiencia.transporteID=event.getTransporteID();
            experiencia.hotelID=event.getHotelID();
        });

        apply((DescripcionPlanActualizada event)->{
            experiencia.plan.actualizarDescripcion(event.getDescripcion());
        });

        apply((EmailGuiaActualizado event)->{
            experiencia.guia.actualizarEmail(event.getEmail());
        });

        apply((GuiaAgregado event)->{
            experiencia.guia=new Guia(event.getGuiaID(),event.getNombre(),event.getLocalidad(),event.getEmail(),event.getTelefono());
        });

        apply((LocacionLugarActualizada event)->{
            experiencia.lugar.actualizarLocacion(event.getLocacion());
        });

        apply((LocalidadGuiaActualizada event)->{
            experiencia.guia.actualizarLocalidad(event.getLocalidad());
        });

        apply((LugarAgregado event)->{
            experiencia.lugar=new Lugar(event.getLugarID(),event.getRango(),event.getLocacion());
        });

        apply((PlanAgregado event)->{
            experiencia.plan=new Plan(event.getPlanID(),event.getDescripcion());
        });

        apply((RangoLugarActualizado event)->{
            experiencia.lugar.actualizarRango(event.getRango());
        });

        apply((TelefonoGuiaActualizado event)->{
            experiencia.guia.actualizarTelefono(event.getTelefono());
        });



    }
}
