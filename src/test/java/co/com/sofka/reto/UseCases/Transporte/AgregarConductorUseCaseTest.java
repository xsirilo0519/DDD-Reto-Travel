package co.com.sofka.reto.UseCases.Transporte;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Generic.Values.*;
import co.com.sofka.reto.Domain.Hotel.Command.AgregarRecreacionista;
import co.com.sofka.reto.Domain.Hotel.Events.HotelCreado;
import co.com.sofka.reto.Domain.Hotel.Events.RecreacionistaAgregado;
import co.com.sofka.reto.Domain.Transporte.Commands.AgregarConductor;
import co.com.sofka.reto.Domain.Transporte.Events.ConductorAgregado;
import co.com.sofka.reto.Domain.Transporte.Events.TransporteCreado;
import co.com.sofka.reto.Domain.Transporte.Values.ConductorID;
import co.com.sofka.reto.Domain.Transporte.Values.TransporteID;
import co.com.sofka.reto.UseCases.Hotel.AgregarRecreacionistaUseCase;
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
class AgregarConductorUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Agregar Conductor")
    public void AgregarConductor(){
        TransporteID transporteID = new TransporteID();
        ConductorID conductorID =ConductorID.of("xxxx");
        Nombre nombre = new Nombre("Juan");
        Localidad localidad= new Localidad("Medellin");
        Email email=new Email("juan@hotmail.com");
        Telefono telefono=new Telefono(3242323.0);

        var command=new AgregarConductor(transporteID,conductorID,nombre,telefono,email,localidad);
        var useCase=new AgregarConductorUseCase();

        Mockito.when(repository.getEventsBy(conductorID.value())).thenReturn(EventStored());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(conductorID.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        ConductorAgregado event = (ConductorAgregado) events.get(0);

        Assertions.assertEquals(conductorID.value() , event.getConductorID().value());
        Assertions.assertEquals(nombre.value() , event.getNombre().value());
        Assertions.assertEquals(email.value() , event.getEmail().value());
        Assertions.assertEquals(telefono.value(), event.getTelefono().value());
        Assertions.assertEquals(localidad.value(), event.getLocalidad().value());
        Mockito.verify(repository).getEventsBy(conductorID.value());
    }

    private List<DomainEvent> EventStored() {
        return List.of(
                new TransporteCreado(
                        new Descripcion("Buen servicio")
                )
        );
    }


}