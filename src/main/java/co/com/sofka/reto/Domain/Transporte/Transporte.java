package co.com.sofka.reto.Domain.Transporte;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Generic.Values.*;
import co.com.sofka.reto.Domain.Hotel.Events.RecreacionistaAgregado;
import co.com.sofka.reto.Domain.Hotel.Hotel;
import co.com.sofka.reto.Domain.Hotel.HotelChange;
import co.com.sofka.reto.Domain.Hotel.Values.HotelID;
import co.com.sofka.reto.Domain.Hotel.Values.RecreacionistaID;
import co.com.sofka.reto.Domain.Transporte.Events.*;
import co.com.sofka.reto.Domain.Transporte.Values.*;

import java.util.List;
import java.util.Objects;

public class Transporte extends AggregateEvent<TransporteID> {
    protected Descripcion descripcion;
    protected Conductor conductor;
    protected Vehiculo vehiculo;
    protected Responsable responsable;

    public Transporte(TransporteID transporteID,Descripcion descripcion){
        super(transporteID);
        appendChange(new TransporteCreado(descripcion));
    }

    private Transporte (TransporteID transporteID){
        super(transporteID);
        subscribe(new TransporteChange(this));
    }

    public static Transporte from(TransporteID transporteID, List<DomainEvent> events){
        var transporte=new Transporte(transporteID);
        events.forEach(transporte::applyEvent);
        return transporte;
    }

    public void ActualizarCapacidadVehiculo(Placa placa,Capacidad capacidad){
        Objects.requireNonNull(capacidad);
        Objects.requireNonNull(placa);
        appendChange(new CapacidadVehiculoActualizada(placa,capacidad));
    }

    public void ActualizarEmailResponsable(ResponsableID responsableID, Email email){
        Objects.requireNonNull(responsableID);
        Objects.requireNonNull(email);
        appendChange(new EmailResponsableActualizado(responsableID,email));
    }

    public void ActualizarLocalidadResponsable(ResponsableID responsableID, Localidad localidad){
        Objects.requireNonNull(responsableID);
        Objects.requireNonNull(localidad);
        appendChange(new LocalidadResponsableActualizada(responsableID,localidad));
    }

    public void ActualizarTelefonoResponsable(ResponsableID responsableID, Telefono telefono){
        Objects.requireNonNull(responsableID);
        Objects.requireNonNull(telefono);
        appendChange(new TelefonoResponsableActualizado(responsableID,telefono));
    }
    public void ActualizarEmailConductor(ConductorID conductorID, Email email){
        Objects.requireNonNull(conductorID);
        Objects.requireNonNull(email);
        appendChange(new EmailConductorActualizado(conductorID,email));
    }

    public void ActualizarLocalidadConductor(ConductorID conductorID, Localidad localidad){
        Objects.requireNonNull(conductorID);
        Objects.requireNonNull(localidad);
        appendChange(new LocalidadConductorActualizada(conductorID,localidad));
    }

    public void ActualizarTelefonoConductor(ConductorID conductorID, Telefono telefono){
        Objects.requireNonNull(conductorID);
        Objects.requireNonNull(telefono);
        appendChange(new TelefonoConductorActualizado(conductorID,telefono));
    }

    public void AgregarConductor(ConductorID conductorID, Nombre nombre, Telefono telefono, Email email, Localidad localidad){
        Objects.requireNonNull(conductorID);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(telefono);
        Objects.requireNonNull(email);
        Objects.requireNonNull(localidad);
        appendChange(new ConductorAgregado(conductorID,nombre,telefono,email,localidad));
    }
    public void AgregarResponsable(ResponsableID responsableID, Nombre nombre, Telefono telefono, Email email, Localidad localidad){
        Objects.requireNonNull(responsableID);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(telefono);
        Objects.requireNonNull(email);
        Objects.requireNonNull(localidad);
        appendChange(new ResponsableAgregado(responsableID,nombre,telefono,email,localidad));
    }

    public void AgregarVehiculo(Placa placa,Capacidad capacidad,Modelo modelo){
        Objects.requireNonNull(placa);
        Objects.requireNonNull(capacidad);
        Objects.requireNonNull(modelo);
        appendChange(new VehiculoAgregado(placa,capacidad,modelo));
    }

    public Descripcion descripcion() {
        return descripcion;
    }

    public Conductor conductor() {
        return conductor;
    }

    public Vehiculo vehiculo() {
        return vehiculo;
    }

    public Responsable responsable() {
        return responsable;
    }
}
