package co.com.sofka.reto.UseCases.Command.Hotel;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Generic.Values.Nombre;
import co.com.sofka.reto.Domain.Hotel.Command.AgregarHabitacion;
import co.com.sofka.reto.Domain.Hotel.Events.HabitacionAgregada;
import co.com.sofka.reto.Domain.Hotel.Events.HotelCreado;
import co.com.sofka.reto.Domain.Hotel.Values.Cant_Cama;
import co.com.sofka.reto.Domain.Hotel.Values.Estado;
import co.com.sofka.reto.Domain.Hotel.Values.HabitacionID;
import co.com.sofka.reto.Domain.Hotel.Values.HotelID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class AgregarHabitacionUseCaseTest {
    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Agregar Habitacion")
    public void AgregarHabitacion(){
        //arrange
        HotelID hotelID=new HotelID();
        HabitacionID habitacionID=new HabitacionID();
        Cant_Cama cant_cama=new Cant_Cama(2);
        Estado estado= new Estado(true);

        var command=new AgregarHabitacion(hotelID,habitacionID,estado,cant_cama);
        var useCase=new AgregarHabitacionUseCase();

        Mockito.when(repository.getEventsBy(habitacionID.value())).thenReturn(EventStored());
        useCase.addRepository(repository);
        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(habitacionID.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        HabitacionAgregada event = (HabitacionAgregada) events.get(0);

        Assertions.assertEquals(habitacionID.value() , event.getHabitacionID().value());
        Assertions.assertEquals(estado.value() , event.getEstado().value());
        Assertions.assertEquals(cant_cama.value() , event.getCant_cama().value());
        Mockito.verify(repository).getEventsBy(habitacionID.value());


    }

    private List<DomainEvent> EventStored() {
        return List.of(
                new HotelCreado(
                        new Nombre("El hotel")
                ),new HabitacionAgregada(
                        HabitacionID.of("2"),
                        new Estado(Boolean.FALSE),
                        new Cant_Cama(1)
                )
        );
    }
}