package co.com.sofka.reto.Domain.Experiencia;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Experiencia.Events.*;
import co.com.sofka.reto.Domain.Experiencia.Values.*;
import co.com.sofka.reto.Domain.Generic.Values.*;
import co.com.sofka.reto.Domain.Hotel.Hotel;
import co.com.sofka.reto.Domain.Hotel.Values.HotelID;
import co.com.sofka.reto.Domain.Transporte.Values.TransporteID;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Experiencia extends AggregateEvent<ExperienciaID> {

    protected HotelID hotelID;
    protected TransporteID transporteID;
    protected Precio precio;
    protected Plan plan;
    protected Lugar lugar;
    protected Guia guia;

    public Experiencia (ExperienciaID experienciaID,TransporteID transporteID,HotelID hotelID,Precio precio){
        super(experienciaID);
        subscribe(new ExperienciaChange(this));
        appendChange(new ExperienciaCreada(transporteID,hotelID,precio));

    }
    private Experiencia (ExperienciaID experienciaID){
        super(experienciaID);
        subscribe(new ExperienciaChange(this));
    }

    public static Experiencia from(ExperienciaID experienciaID, List<DomainEvent> events){
        var experiencia=new Experiencia(experienciaID);
        events.forEach(experiencia::applyEvent);
        return experiencia;
    }

    public void ActualizarDescripcionPlan(PlanID planID, Descripcion descripcion){
        Objects.requireNonNull(planID);
        Objects.requireNonNull(descripcion);
        appendChange(new DescripcionPlanActualizada(planID,descripcion));
    }

    public void ActualizarEmailGuia(GuiaID guiaID, Email email){
        Objects.requireNonNull(guiaID);
        Objects.requireNonNull(email);
        appendChange(new EmailGuiaActualizado(guiaID,email));
    }

    public void ActualizarTelefonoGuia(GuiaID guiaID, Telefono telefono){
        Objects.requireNonNull(guiaID);
        Objects.requireNonNull(telefono);
        appendChange(new TelefonoGuiaActualizado(guiaID,telefono));
    }

    public void ActualizarLocalidadGuia(GuiaID guiaID, Localidad localidad){
        Objects.requireNonNull(guiaID);
        Objects.requireNonNull(localidad);
        appendChange(new LocalidadGuiaActualizada(guiaID,localidad));
    }

    public void ActualizarRangoLugar(LugarID lugarID,Rango rango){
        Objects.requireNonNull(lugarID);
        Objects.requireNonNull(rango);
        appendChange(new RangoLugarActualizado(lugarID,rango));
    }

    public void ActualizarLocacionLugar(LugarID lugarID, Locacion locacion){
        Objects.requireNonNull(lugarID);
        Objects.requireNonNull(locacion);
        appendChange(new LocacionLugarActualizada(lugarID,locacion));
    }

    public void AgregagrGuia(GuiaID guiaID, Nombre nombre, Telefono telefono,Email email,Localidad localidad){
        Objects.requireNonNull(guiaID);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(telefono);
        Objects.requireNonNull(email);
        Objects.requireNonNull(localidad);
        appendChange(new GuiaAgregado(guiaID,nombre,telefono,email,localidad));
    }

    public void AgregarLugar(LugarID lugarID,Rango rango,Locacion locacion){
        Objects.requireNonNull(lugarID);
        Objects.requireNonNull(rango);
        Objects.requireNonNull(locacion);
        appendChange(new LugarAgregado(lugarID,rango,locacion));
    }

    public void AgregarPlan(PlanID planID,Descripcion descripcion){
        Objects.requireNonNull(planID);
        Objects.requireNonNull(descripcion);
        appendChange(new PlanAgregado(planID,descripcion));
    }

    public void ActualizarPrecio(Precio precio){
        this.precio=precio;
    }

    public Plan plan() {
        return plan;
    }

    public Lugar lugar() {
        return lugar;
    }

    public Guia guia() {
        return guia;
    }

    public HotelID hotelID() {
        return hotelID;
    }

    public TransporteID transporteID() {
        return transporteID;
    }

    public Precio precio() {
        return precio;
    }
}
