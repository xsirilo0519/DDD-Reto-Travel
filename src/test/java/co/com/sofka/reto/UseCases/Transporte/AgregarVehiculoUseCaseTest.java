package co.com.sofka.reto.UseCases.Transporte;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Generic.Values.Descripcion;
import co.com.sofka.reto.Domain.Transporte.Commands.AgregarVehiculo;
import co.com.sofka.reto.Domain.Transporte.Events.ConductorAgregado;
import co.com.sofka.reto.Domain.Transporte.Events.TransporteCreado;
import co.com.sofka.reto.Domain.Transporte.Events.VehiculoAgregado;
import co.com.sofka.reto.Domain.Transporte.Values.Capacidad;
import co.com.sofka.reto.Domain.Transporte.Values.Modelo;
import co.com.sofka.reto.Domain.Transporte.Values.Placa;
import co.com.sofka.reto.Domain.Transporte.Values.TransporteID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AgregarVehiculoUseCaseTest {
    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Agregar vehiculo")
    public void AgregarVehiculo(){
        TransporteID transporteID= new TransporteID();
        Placa placa= Placa.of("xxxx");
        Capacidad capacidad= new Capacidad(40);
        Modelo modelo= new Modelo(2005);

        var command=new AgregarVehiculo(transporteID,placa,capacidad,modelo);
        var useCase= new AgregarVehiculoUseCase();

        Mockito.when(repository.getEventsBy(placa.value())).thenReturn(EventStored());
        useCase.addRepository(repository);


        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(placa.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        VehiculoAgregado event = (VehiculoAgregado) events.get(0);

        Assertions.assertEquals(placa.value() , event.getPlaca().value());
        Assertions.assertEquals(capacidad.value() , event.getCapacidad().value());
        Assertions.assertEquals(modelo.value() , event.getModelo().value());
        Mockito.verify(repository).getEventsBy(placa.value());
    }

    private List<DomainEvent> EventStored() {
        return List.of(
                new TransporteCreado(
                        new Descripcion("Buen servicio")
                )
        );
    }

}