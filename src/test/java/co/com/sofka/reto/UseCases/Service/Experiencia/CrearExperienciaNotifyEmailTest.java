package co.com.sofka.reto.UseCases.Service.Experiencia;

import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.reto.Domain.Experiencia.Events.ExperienciaCreada;
import co.com.sofka.reto.Domain.Experiencia.Values.ExperienciaID;
import co.com.sofka.reto.Domain.Experiencia.Values.Precio;
import co.com.sofka.reto.Domain.Hotel.Values.HotelID;
import co.com.sofka.reto.Domain.Transporte.Values.TransporteID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CrearExperienciaNotifyEmailTest {
    @Mock
    IEnviarEmail servicio;

    @Test
    public void CrearExperienciaNotifyEmail(){
        ExperienciaID experienciaID= ExperienciaID.of("xxxx");
        TransporteID transporteID= TransporteID.of("jjjj");
        HotelID hotelID = HotelID.of("wwww");
        Precio precio = new Precio(2000.0);

        var event=new ExperienciaCreada(transporteID,hotelID,precio);
        event.setAggregateRootId(experienciaID.value());

        var useCase= new CrearExperienciaNotifyEmail();

        when(servicio.send(
                experienciaID,
                "publicidad@colturismo.com",
                "Nueva Experiencia disponible: "+event.aggregateRootId())
                ).thenReturn(true);

        ServiceBuilder builder = new ServiceBuilder();
        builder.addService(servicio);
        useCase.addServiceBuilder(builder);

        UseCaseHandler.getInstance()
                .syncExecutor(useCase,new TriggeredEvent<>(event))
                .orElseThrow();

        verify(servicio).send(experienciaID,
                "publicidad@colturismo.com",
                "Nueva Experiencia disponible: "+experienciaID.value());
    }
}