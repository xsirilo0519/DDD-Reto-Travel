package co.com.sofka.reto.Domain.Hotel;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Generic.Values.*;
import co.com.sofka.reto.Domain.Hotel.Events.*;
import co.com.sofka.reto.Domain.Hotel.Values.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Hotel extends AggregateEvent<HotelID> {
    protected Nombre nombre;
    protected List<Habitacion> habitacionList;
    protected Recreacionista recreacionista;
    protected Actividad actividad;

    public Hotel(HotelID hotelID,Nombre nombre) {
        super(hotelID);
        subscribe(new HotelChange(this));
        appendChange(new HotelCreado(nombre));
    }
    private Hotel (HotelID hotelID){
        super(hotelID);
        subscribe(new HotelChange(this));
    }

    public static Hotel from(HotelID hotelID, List<DomainEvent> events){
        var hotel=new Hotel(hotelID);
        events.forEach(hotel::applyEvent);
        return hotel;
    }

    public void ActualizarCant_CamaHabitacion(HabitacionID habitacionID,Cant_Cama cant_cama){
        Objects.requireNonNull(habitacionID);
        Objects.requireNonNull(cant_cama);
        appendChange(new Cant_CamaHabitacionActualizada(habitacionID,cant_cama));
    }

    public void ActualizarEstadoHabitacion(HabitacionID habitacionID, Estado estado){
        Objects.requireNonNull(habitacionID);
        Objects.requireNonNull(estado);
        appendChange(new EstadoHabitacionActualizada(habitacionID,estado));
    }

    public void ActualizarLocalidadRecreacionista(RecreacionistaID recreacionistaID, Localidad localidad){
        Objects.requireNonNull(recreacionistaID);
        Objects.requireNonNull(localidad);
        appendChange(new LocalidadRecreacionistaActualizada(recreacionistaID,localidad));
    }

    public void ActualizarTelefonoRecreacionista(RecreacionistaID recreacionistaID, Telefono telefono){
        Objects.requireNonNull(recreacionistaID);
        Objects.requireNonNull(telefono);
        appendChange(new TelefonoRecreacionistaActualizado(recreacionistaID,telefono));
    }

    public void ActualizarEmailRecreacionista(RecreacionistaID recreacionistaID, Email email){
        Objects.requireNonNull(recreacionistaID);
        Objects.requireNonNull(email);
        appendChange(new EmailRecreacionistaActualizado(recreacionistaID,email));
    }

    public void ActualizarDescripcionActividad(ActividadID actividadID, Descripcion descripcion){
        Objects.requireNonNull(actividadID);
        Objects.requireNonNull(descripcion);
        appendChange(new DescripcionActividadActualizada(actividadID,descripcion));
    }

    public void AgregarHabitacion(HabitacionID habitacionID,Estado estado,Cant_Cama cant_cama){
        Objects.requireNonNull(habitacionID);
        Objects.requireNonNull(estado);
        Objects.requireNonNull(cant_cama);
        appendChange(new HabitacionAgregada(habitacionID,estado,cant_cama));
    }

    public void AgregarRecreacionista(RecreacionistaID recreacionistaID, Nombre nombre, Telefono telefono, Email email, Localidad localidad){
        Objects.requireNonNull(recreacionistaID);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(telefono);
        Objects.requireNonNull(email);
        Objects.requireNonNull(localidad);
        appendChange(new RecreacionistaAgregado(recreacionistaID,nombre,telefono,email,localidad));
    }

    public void AgregarActividad(ActividadID actividadID,Descripcion descripcion){
        Objects.requireNonNull(actividadID);
        Objects.requireNonNull(descripcion);
        appendChange(new ActividadAgregada(actividadID,descripcion));
    }

    protected Optional<Habitacion> getHabitacionPorID(HabitacionID habitacionID){
       return habitacionList.stream().filter(habitacion->habitacion.equals(habitacionID)).findFirst();
    }


    public Nombre nombre() {
        return nombre;
    }

    public List<Habitacion> habitacionList() {
        return habitacionList;
    }

    public Recreacionista recreacionista() {
        return recreacionista;
    }

    public Actividad actividad() {
        return actividad;
    }
}
