package co.com.sofka.reto.UseCases.Command.Experiencia;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.reto.Domain.Experiencia.Commands.AgregarGuia;
import co.com.sofka.reto.Domain.Experiencia.Experiencia;

public class AgregarGuiaUseCase extends UseCase<RequestCommand<AgregarGuia>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarGuia> agregarGuiaRequestCommand) {
        var command=agregarGuiaRequestCommand.getCommand();
        var experiencia= Experiencia.from(command.getExperienciaID(),retrieveEvents(command.getGuiaID().value()));

        experiencia.AgregagrGuia(
                command.getGuiaID(),
                command.getNombre(),
                command.getTelefono(),
                command.getEmail(),
                command.getLocalidad()        );

        emit().onResponse(new ResponseEvents(experiencia.getUncommittedChanges()));
    }


}
