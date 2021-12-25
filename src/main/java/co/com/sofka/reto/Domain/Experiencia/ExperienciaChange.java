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
            experiencia.AgregagrGuia(event.getGuiaID(),event.getNombre(),event.getTelefono(),event.getEmail(),event.getLocalidad());
        });

        apply((LocacionLugarActualizada event)->{
            experiencia.lugar.actualizarLocacion(event.getLocacion());
        });

        apply((LocalidadGuiaActualizada event)->{
            experiencia.guia.actualizarLocalidad(event.getLocalidad());
        });

        apply((LugarAgregado event)->{
            experiencia.AgregarLugar(event.getLugarID(),event.getRango(),event.getLocacion());
        });

        apply((PlanAgregado event)->{
            experiencia.AgregarPlan(event.getPlanID(),event.getDescripcion());
        });

        apply((RangoLugarActualizado event)->{
            experiencia.lugar.actualizarRango(event.getRango());
        });

        apply((TelefonoGuiaActualizado event)->{
            experiencia.guia.actualizarTelefono(event.getTelefono());
        });



    }
}
