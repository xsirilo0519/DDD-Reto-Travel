package co.com.sofka.reto.Domain.Hotel.Events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Hotel.Values.Estado;
import co.com.sofka.reto.Domain.Hotel.Values.HabitacionID;

public class EstadoHabitacionActualizada extends DomainEvent {
    private final HabitacionID habitacionID;
    private final Estado estado;
    public EstadoHabitacionActualizada(HabitacionID habitacionID, Estado estado) {
        super("sofka.hotel.EstadoHabitacionActualizada");
        this.habitacionID=habitacionID;
        this.estado=estado;
    }

    public HabitacionID getHabitacionID() {
        return habitacionID;
    }

    public Estado getEstado() {
        return estado;
    }
}
