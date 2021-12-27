package co.com.sofka.reto.Service.Experiencia;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.reto.Domain.Experiencia.Events.ExperienciaCreada;
import co.com.sofka.reto.Domain.Experiencia.Values.ExperienciaID;

import java.util.List;

public class CrearExperienciaNotifyEmail extends UseCase<TriggeredEvent<ExperienciaCreada>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<ExperienciaCreada> experienciaCreadaTriggeredEvent) {
        var event=experienciaCreadaTriggeredEvent.getDomainEvent();
        var service=getService(IEnviarEmail.class).orElseThrow();
        boolean isValue = service.send(ExperienciaID.of(event.aggregateRootId()),
                "publicidad@colturismo.com",
                "Nueva Experiencia disponible: "+event.aggregateRootId());
        if(!isValue)
            throw  new BusinessException(event.aggregateRootId(),"No se puede enviar");

        emit().onResponse(new ResponseEvents(List.of()));




    }
}
