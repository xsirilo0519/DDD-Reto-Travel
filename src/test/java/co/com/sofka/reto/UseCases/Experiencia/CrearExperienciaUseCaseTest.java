package co.com.sofka.reto.UseCases.Experiencia;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.reto.Domain.Experiencia.Commands.CrearExperiencia;
import co.com.sofka.reto.Domain.Experiencia.Events.ExperienciaCreada;
import co.com.sofka.reto.Domain.Experiencia.Values.ExperienciaID;
import co.com.sofka.reto.Domain.Experiencia.Values.Precio;
import co.com.sofka.reto.Domain.Hotel.Values.HotelID;
import co.com.sofka.reto.Domain.Transporte.Values.TransporteID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearExperienciaUseCaseTest {
    @Test
    public void CrearExperiencia(){
        //Arrange
        ExperienciaID experienciaID= ExperienciaID.of("xxxx");
        TransporteID transporteID= TransporteID.of("jjjj");
        HotelID hotelID = HotelID.of("wwww");
        Precio precio = new Precio(2000.0);

        var command=new CrearExperiencia(experienciaID,transporteID,hotelID,precio);
        var useCase=new CrearExperienciaUseCase();

        //Add

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase,new RequestCommand<>(command))
                .orElseThrow();

        ExperienciaCreada event=(ExperienciaCreada) events.getDomainEvents().get(0);

        Assertions.assertEquals("xxxx",event.aggregateRootId());
        Assertions.assertEquals("jjjj",event.getTransporteID().value());
        Assertions.assertEquals("wwww",event.getHotelID().value());
        Assertions.assertEquals(precio.value(),event.getPrecio().value());
    }

}