package co.com.sofka.reto.UseCases.Command.Experiencia;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Experiencia.Commands.AgregarPlan;
import co.com.sofka.reto.Domain.Experiencia.Events.ExperienciaCreada;
import co.com.sofka.reto.Domain.Experiencia.Events.PlanAgregado;
import co.com.sofka.reto.Domain.Experiencia.Values.ExperienciaID;
import co.com.sofka.reto.Domain.Experiencia.Values.PlanID;
import co.com.sofka.reto.Domain.Experiencia.Values.Precio;
import co.com.sofka.reto.Domain.Generic.Values.Descripcion;
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
class AgregarPlanUseCaseTest {
    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Agregar Plan")
    public void AgregarPlan(){
        //Arrange
        ExperienciaID experienciaID=new ExperienciaID();
        PlanID planID=PlanID.of("xxxx");
        Descripcion descripcion= new Descripcion("Playa tortuga");

        var command= new AgregarPlan(experienciaID,planID,descripcion);
        var useCase=new AgregarPlanUseCase();

        Mockito.when(repository.getEventsBy(planID.value())).thenReturn(EventStored());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(planID.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        PlanAgregado event = (PlanAgregado) events.get(0);

        Assertions.assertEquals(planID.value() , event.getPlanID().value());
        Assertions.assertEquals(descripcion.value() , event.getDescripcion().value());
        Mockito.verify(repository).getEventsBy(planID.value());

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