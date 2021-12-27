package co.com.sofka.reto.UseCases.Service.Hotel;

import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.reto.Domain.Generic.Values.Nombre;
import co.com.sofka.reto.Domain.Hotel.Events.HotelCreado;
import co.com.sofka.reto.Domain.Hotel.Values.HotelID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CrearHotelNotifyTest {
    @Mock
    IMensaje servicio;

    @Test
    public void CrearHotelNotify(){
        HotelID hotelID = HotelID.of("xxxx");
        Nombre nombre = new Nombre("La luna");

        var event= new HotelCreado(nombre);
        event.setAggregateRootId(hotelID.value());

        var useCase= new CrearHotelNotify();

        Mockito.when(servicio.mensaje(hotelID.value(),"El hotel "+nombre+", Se creó")).thenReturn(true);

        ServiceBuilder builder = new ServiceBuilder();
        builder.addService(servicio);
        useCase.addServiceBuilder(builder);

        UseCaseHandler.getInstance()
                .syncExecutor(useCase,new TriggeredEvent<>(event))
                .orElseThrow();

        verify(servicio).mensaje(hotelID.value(),"El hotel "+event.getNombre()+", Se creó");

    }
}