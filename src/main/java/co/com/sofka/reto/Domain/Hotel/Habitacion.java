package co.com.sofka.reto.Domain.Hotel;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.reto.Domain.Hotel.Values.Cant_Cama;
import co.com.sofka.reto.Domain.Hotel.Values.Estado;
import co.com.sofka.reto.Domain.Hotel.Values.HabitacionID;

import java.util.Objects;

public class Habitacion extends Entity<HabitacionID> {

    private Estado estado;
    private Cant_Cama cant_cama;

    public Habitacion(HabitacionID habitacionID,Estado estado,Cant_Cama cant_cama){
        super(habitacionID);
        this.estado=estado;
        this.cant_cama=cant_cama;
    }

    public void actualizarEstado(Estado estado){
        this.estado= Objects.requireNonNull(estado);
    }

    public void actualizarCant_cama(Cant_Cama cant_cama){
        this.cant_cama=Objects.requireNonNull(cant_cama);
    }
    public Estado estado() {
        return estado;
    }

    public Cant_Cama cant_cama() {
        return cant_cama;
    }
}
