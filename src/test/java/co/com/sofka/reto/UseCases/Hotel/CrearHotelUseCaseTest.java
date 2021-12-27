package co.com.sofka.reto.UseCases.Hotel;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.reto.Domain.Generic.Values.Nombre;
import co.com.sofka.reto.Domain.Hotel.Command.CrearHotel;
import co.com.sofka.reto.Domain.Hotel.Events.HotelCreado;
import co.com.sofka.reto.Domain.Hotel.Values.HotelID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearHotelUseCaseTest {
    @Test
    public void CrearHotel(){
        //Arrange
        HotelID hotelID = HotelID.of("xxxx");
        Nombre nombre=new Nombre("Hola");

        var command= new CrearHotel(hotelID,nombre);
        var useCase=new CrearHotelUseCase();

        //Add

        var events= UseCaseHandler.getInstance()
                .syncExecutor(useCase,new RequestCommand<>(command))
                .orElseThrow();

        HotelCreado event =(HotelCreado) events.getDomainEvents().get(0);

        Assertions.assertEquals("xxxx",event.aggregateRootId());
        Assertions.assertEquals("Hola",event.getNombre().value());
    }

}