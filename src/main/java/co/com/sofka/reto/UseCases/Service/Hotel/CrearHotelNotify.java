package co.com.sofka.reto.UseCases.Service.Hotel;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.reto.Domain.Experiencia.Events.ExperienciaCreada;
import co.com.sofka.reto.Domain.Hotel.Events.HotelCreado;
import co.com.sofka.reto.UseCases.Service.Experiencia.IEnviarEmail;

import java.util.List;

public class CrearHotelNotify extends UseCase<TriggeredEvent<HotelCreado>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<HotelCreado> hotelCreadoTriggeredEvent) {
        var event=hotelCreadoTriggeredEvent.getDomainEvent();
        var service=getService(IMensaje.class).orElseThrow();

        service.mensaje(event.aggregateRootId(),"El hotel "+event.getNombre()+", Se creó");

        emit().onResponse(new ResponseEvents(List.of()));
    }
}
