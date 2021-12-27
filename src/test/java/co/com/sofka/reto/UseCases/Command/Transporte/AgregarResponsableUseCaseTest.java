package co.com.sofka.reto.UseCases.Command.Transporte;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.Domain.Generic.Values.*;
import co.com.sofka.reto.Domain.Transporte.Commands.AgregarResponsable;
import co.com.sofka.reto.Domain.Transporte.Events.ResponsableAgregado;
import co.com.sofka.reto.Domain.Transporte.Events.TransporteCreado;
import co.com.sofka.reto.Domain.Transporte.Values.ResponsableID;
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
class AgregarResponsableUseCaseTest {
    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Agregar Responsable")
    public void AgregarResponsable(){
        TransporteID transporteID = new TransporteID();
        ResponsableID responsableID =ResponsableID.of("xxxx");
        Nombre nombre = new Nombre("Juan");
        Localidad localidad= new Localidad("Medellin");
        Email email=new Email("juan@hotmail.com");
        Telefono telefono=new Telefono(3242323.0);

        var command=new AgregarResponsable(transporteID,responsableID,nombre,telefono,email,localidad);
        var useCase=new AgregarResponsableUseCase();

        Mockito.when(repository.getEventsBy(responsableID.value())).thenReturn(EventStored());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(responsableID.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        ResponsableAgregado event = (ResponsableAgregado) events.get(0);

        Assertions.assertEquals(responsableID.value() , event.getResponsableID().value());
        Assertions.assertEquals(nombre.value() , event.getNombre().value());
        Assertions.assertEquals(email.value() , event.getEmail().value());
        Assertions.assertEquals(telefono.value(), event.getTelefono().value());
        Assertions.assertEquals(localidad.value(), event.getLocalidad().value());
        Mockito.verify(repository).getEventsBy(responsableID.value());
    }

    private List<DomainEvent> EventStored() {
        return List.of(
                new TransporteCreado(
                        new Descripcion("Buen servicio")
                )
        );

}

}