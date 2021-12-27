package co.com.sofka.reto.UseCases.Transporte;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.reto.Domain.Generic.Values.Descripcion;
import co.com.sofka.reto.Domain.Hotel.Events.HotelCreado;
import co.com.sofka.reto.Domain.Transporte.Commands.CrearTransporte;
import co.com.sofka.reto.Domain.Transporte.Events.TransporteCreado;
import co.com.sofka.reto.Domain.Transporte.Values.TransporteID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

class CrearTransporteUseCaseTest {
    @Test
    public void CrearTransporte(){
        //arranque
        TransporteID transporteID=TransporteID.of("xxxx");
        Descripcion descripcion=new Descripcion("Este transporte esta muy bien valorado");

        var command= new CrearTransporte(transporteID,descripcion);
        var useCase=new CrearTransporteUseCase();

        //Add

        var events= UseCaseHandler.getInstance()
                .syncExecutor(useCase,new RequestCommand<>(command))
                .orElseThrow();

        TransporteCreado event =(TransporteCreado) events.getDomainEvents().get(0);

        Assertions.assertEquals("xxxx",event.aggregateRootId());
        Assertions.assertEquals("Este transporte esta muy bien valorado",event.getDescripcion().value());
    }




}