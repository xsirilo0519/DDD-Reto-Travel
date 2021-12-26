package co.com.sofka.reto.Domain.Hotel;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.reto.Domain.Hotel.Events.*;

public class HotelChange extends EventChange {
    public HotelChange(Hotel hotel){
        apply((HotelCreado event)->{
            hotel.nombre=event.getNombre();
        });

        apply((ActividadAgregada event)->{
            hotel.AgregarActividad(event.getActividadID(),event.getDescripcion());
        });

        apply((Cant_CamaHabitacionActualizada event)->{
            Habitacion habitacion=hotel.getHabitacionPorID(event.getHabitacionID()).orElseThrow(()->new IllegalArgumentException("No se encontro la habitacion"));
            habitacion.actualizarCant_cama(event.getCant_cama());
        });

        apply((DescripcionActividadActualizada event)->{
            hotel.actividad.actualizarDescripcion(event.getDescripcion());
        });

        apply((EmailRecreacionistaActualizado event)->{
            hotel.recreacionista.actualizarEmail(event.getEmail());
        });

        apply((EstadoHabitacionActualizada event)->{
            Habitacion habitacion=hotel.getHabitacionPorID(event.getHabitacionID()).orElseThrow(()->new IllegalArgumentException("No se encontro la habitacion"));
            habitacion.actualizarEstado(event.getEstado());
        });

        apply((HabitacionAgregada event)->{
            hotel.habitacionList.add(new Habitacion(event.getHabitacionID(),event.getEstado(),event.getCant_cama()));
        });

        apply((LocalidadRecreacionistaActualizada event)->{
            hotel.recreacionista.actualizarLocalidad(event.getLocalidad());
        });

        apply((RecreacionistaAgregado event)->{
            hotel.recreacionista=new Recreacionista(event.getRecreacionistaID(),event.getNombre(),event.getLocalidad(),event.getEmail(),event.getTelefono());
        });

        apply((TelefonoRecreacionistaActualizado event)->{
            hotel.recreacionista.actualizarTelefono(event.getTelefono());
        });


    }
}
