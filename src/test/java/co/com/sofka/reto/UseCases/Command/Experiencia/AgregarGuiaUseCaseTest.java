package co.com.sofka.reto.UseCases.Command.Experiencia;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Experiencia.Commands.AgregarGuia;
import co.com.sofka.reto.Domain.Experiencia.Events.ExperienciaCreada;
import co.com.sofka.reto.Domain.Experiencia.Events.GuiaAgregado;
import co.com.sofka.reto.Domain.Experiencia.Values.ExperienciaID;
import co.com.sofka.reto.Domain.Experiencia.Values.GuiaID;
import co.com.sofka.reto.Domain.Experiencia.Values.Precio;
import co.com.sofka.reto.Domain.Generic.Values.Email;
import co.com.sofka.reto.Domain.Generic.Values.Localidad;
import co.com.sofka.reto.Domain.Generic.Values.Nombre;
import co.com.sofka.reto.Domain.Generic.Values.Telefono;
import co.com.sofka.reto.Domain.Hotel.Values.HotelID;
import co.com.sofka.reto.Domain.Transporte.Values.TransporteID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class AgregarGuiaUseCaseTest {
    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Agregar Guia")
    public void AgregarGuia(){

        //arrange
        ExperienciaID experienciaID=new ExperienciaID();
        GuiaID guiaID= GuiaID.of("xxxx");
        Nombre nombre = new Nombre("Juan");
        Localidad localidad= new Localidad("Medellin");
        Email email=new Email("juan@hotmail.com");
        Telefono telefono=new Telefono(3242323.0);

        var command=new AgregarGuia(experienciaID,guiaID,nombre,telefono,email,localidad);
        var useCase=new AgregarGuiaUseCase();

        Mockito.when(repository.getEventsBy(guiaID.value())).thenReturn(EventStored());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(guiaID.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        GuiaAgregado event = (GuiaAgregado) events.get(0);

        Assertions.assertEquals(guiaID.value() , event.getGuiaID().value());
        Assertions.assertEquals(nombre.value() , event.getNombre().value());
        Assertions.assertEquals(email.value() , event.getEmail().value());
        Assertions.assertEquals(telefono.value(), event.getTelefono().value());
        Assertions.assertEquals(localidad.value(), event.getLocalidad().value());
        Mockito.verify(repository).getEventsBy(guiaID.value());


    }


    private List<DomainEvent> EventStored() {
        return List.of(
                new ExperienciaCreada(
                        new TransporteID(),
                        new HotelID(),
                        new Precio(2000.0)
                )
        );
    }
}