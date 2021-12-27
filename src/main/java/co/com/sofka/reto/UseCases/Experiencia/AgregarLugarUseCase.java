package co.com.sofka.reto.UseCases.Experiencia;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.reto.Domain.Experiencia.Commands.AgregarGuia;
import co.com.sofka.reto.Domain.Experiencia.Commands.AgregarLugar;
import co.com.sofka.reto.Domain.Experiencia.Experiencia;

public class AgregarLugarUseCase extends UseCase<RequestCommand<AgregarLugar>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarLugar> agregarLugarRequestCommand) {
        var command=agregarLugarRequestCommand.getCommand();
        var experiencia= Experiencia.from(command.getExperienciaID(),retrieveEvents(command.getLugarID().value()));
        
        experiencia.AgregarLugar(
                command.getLugarID(),
                command.getRango(),
                command.getLocacion()
        );
        
        emit().onResponse(new ResponseEvents(experiencia.getUncommittedChanges()));
    }
}
