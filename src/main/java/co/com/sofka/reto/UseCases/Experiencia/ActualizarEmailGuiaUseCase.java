package co.com.sofka.reto.UseCases.Experiencia;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.reto.Domain.Experiencia.Commands.ActualizarEmailGuia;
import co.com.sofka.reto.Domain.Experiencia.Experiencia;

public class ActualizarEmailGuiaUseCase extends UseCase<RequestCommand<ActualizarEmailGuia>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarEmailGuia> actualizarEmailGuiaRequestCommand) {
        var command=actualizarEmailGuiaRequestCommand.getCommand();
        var experiencia= Experiencia.from(command.getExperienciaID(),retrieveEvents(command.getGuiaID().value()));

        experiencia.ActualizarEmailGuia(command.getGuiaID(),command.getEmail());

        emit().onResponse(new ResponseEvents(experiencia.getUncommittedChanges()));

    }
}
