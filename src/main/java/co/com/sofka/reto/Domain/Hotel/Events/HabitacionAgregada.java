package co.com.sofka.reto.Domain.Hotel.Events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Hotel.Values.Cant_Cama;
import co.com.sofka.reto.Domain.Hotel.Values.Estado;
import co.com.sofka.reto.Domain.Hotel.Values.HabitacionID;

public class HabitacionAgregada extends DomainEvent {
    private final HabitacionID habitacionID;
    private final Estado estado;
    private final Cant_Cama cant_cama;
    public HabitacionAgregada(HabitacionID habitacionID, Estado estado, Cant_Cama cant_cama) {
        super("sofka.hotel.HabitacionAgregada");
        this.habitacionID=habitacionID;
        this.estado=estado;
        this.cant_cama=cant_cama;
    }

    public HabitacionID getHabitacionID() {
        return habitacionID;
    }

    public Estado getEstado() {
        return estado;
    }

    public Cant_Cama getCant_cama() {
        return cant_cama;
    }
}
