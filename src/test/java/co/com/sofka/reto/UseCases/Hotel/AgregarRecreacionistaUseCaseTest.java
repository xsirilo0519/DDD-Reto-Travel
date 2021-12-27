package co.com.sofka.reto.UseCases.Hotel;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Generic.Values.Email;
import co.com.sofka.reto.Domain.Generic.Values.Localidad;
import co.com.sofka.reto.Domain.Generic.Values.Nombre;
import co.com.sofka.reto.Domain.Generic.Values.Telefono;
import co.com.sofka.reto.Domain.Hotel.Command.AgregarRecreacionista;
import co.com.sofka.reto.Domain.Hotel.Events.HotelCreado;
import co.com.sofka.reto.Domain.Hotel.Events.RecreacionistaAgregado;
import co.com.sofka.reto.Domain.Hotel.Values.HotelID;
import co.com.sofka.reto.Domain.Hotel.Values.RecreacionistaID;
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
class AgregarRecreacionistaUseCaseTest {
    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Agregar Recreacionista")
    public void AgregarRecreacionista(){
        //arrange
        HotelID hotelID=new HotelID();
        RecreacionistaID recreacionistaID= RecreacionistaID.of("xxxx");
        Nombre nombre = new Nombre("Juan");
        Localidad localidad= new Localidad("Medellin");
        Email email=new Email("juan@hotmail.com");
        Telefono telefono=new Telefono(3242323.0);

        var command=new AgregarRecreacionista(hotelID,recreacionistaID,nombre,telefono,email,localidad);
        var useCase=new AgregarRecreacionistaUseCase();

        Mockito.when(repository.getEventsBy(recreacionistaID.value())).thenReturn(EventStored());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(recreacionistaID.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        RecreacionistaAgregado event = (RecreacionistaAgregado) events.get(0);

        Assertions.assertEquals(recreacionistaID.value() , event.getRecreacionistaID().value());
        Assertions.assertEquals(nombre.value() , event.getNombre().value());
        Assertions.assertEquals(email.value() , event.getEmail().value());
        Assertions.assertEquals(telefono.value(), event.getTelefono().value());
        Assertions.assertEquals(localidad.value(), event.getLocalidad().value());
        Mockito.verify(repository).getEventsBy(recreacionistaID.value());


    }


    private List<DomainEvent> EventStored() {
        return List.of(
                new HotelCreado(
                        new Nombre("El hotel")
                )
        );
    }


}