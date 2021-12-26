package co.com.sofka.reto.Domain.Hotel.Events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Hotel.Values.Cant_Cama;
import co.com.sofka.reto.Domain.Hotel.Values.HabitacionID;

public class Cant_CamaHabitacionActualizada extends DomainEvent {
    private final HabitacionID habitacionID;
    private final Cant_Cama cant_cama;
    public Cant_CamaHabitacionActualizada(HabitacionID habitacionID, Cant_Cama cant_cama) {
        super("sofka.hotel.Cant_CamaHabitacionActualizada");
        this.habitacionID=habitacionID;
        this.cant_cama=cant_cama;
    }

    public HabitacionID getHabitacionID() {
        return habitacionID;
    }

    public Cant_Cama getCant_cama() {
        return cant_cama;
    }
}
