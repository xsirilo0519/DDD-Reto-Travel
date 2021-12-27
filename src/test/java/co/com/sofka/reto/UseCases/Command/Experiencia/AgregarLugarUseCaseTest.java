package co.com.sofka.reto.UseCases.Command.Experiencia;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Experiencia.Commands.AgregarLugar;
import co.com.sofka.reto.Domain.Experiencia.Events.ExperienciaCreada;
import co.com.sofka.reto.Domain.Experiencia.Events.LugarAgregado;
import co.com.sofka.reto.Domain.Experiencia.Values.*;
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
class AgregarLugarUseCaseTest {
    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Agregar Lugar")
    public void AgregarLugar(){
        //Arrange
        ExperienciaID experienciaID=new ExperienciaID();
        LugarID lugarID= LugarID.of("xxxx");
        Rango rango= new Rango("5 estrellas");
        Locacion locacion= new Locacion("Medellin");

        var command=new AgregarLugar(experienciaID,lugarID,rango,locacion);
        var useCase=new AgregarLugarUseCase();

        Mockito.when(repository.getEventsBy(lugarID.value())).thenReturn(EventStored());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(lugarID.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        LugarAgregado event = (LugarAgregado) events.get(0);

        Assertions.assertEquals(lugarID.value() , event.getLugarID().value());
        Assertions.assertEquals(rango.value() , event.getRango().value());
        Assertions.assertEquals(locacion.value() , event.getLocacion().value());
        Mockito.verify(repository).getEventsBy(lugarID.value());
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