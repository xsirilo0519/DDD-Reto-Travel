package co.com.sofka.reto.UseCases.Command.Hotel;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Generic.Values.Descripcion;
import co.com.sofka.reto.Domain.Generic.Values.Nombre;
import co.com.sofka.reto.Domain.Hotel.Command.AgregarActividad;
import co.com.sofka.reto.Domain.Hotel.Events.ActividadAgregada;
import co.com.sofka.reto.Domain.Hotel.Events.HotelCreado;
import co.com.sofka.reto.Domain.Hotel.Values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class AgregarActividadUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Agregar Actividad")
    public void AgregarActividad(){
        //Arrange
        HotelID hotelID=new HotelID();
        ActividadID actividadID=new ActividadID();
        Descripcion descripcion= new Descripcion("Piscinas, Caminata");

        var command=new AgregarActividad(hotelID,actividadID,descripcion);
        var useCase=new AgregarActividadUseCase();

        Mockito.when(repository.getEventsBy(actividadID.value())).thenReturn(EventStored());
        useCase.addRepository(repository);
        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(actividadID.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        ActividadAgregada event = (ActividadAgregada) events.get(0);

        Assertions.assertEquals(actividadID.value() , event.getActividadID().value());
        Assertions.assertEquals(descripcion.value() , event.getDescripcion().value());
        Mockito.verify(repository).getEventsBy(actividadID.value());

    }

    private List<DomainEvent> EventStored() {
        return List.of(
                new HotelCreado(
                        new Nombre("El hotel")
                )
        );
    }

}