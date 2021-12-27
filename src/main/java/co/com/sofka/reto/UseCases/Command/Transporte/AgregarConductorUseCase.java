package co.com.sofka.reto.UseCases.Command.Transporte;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.reto.Domain.Transporte.Commands.AgregarConductor;
import co.com.sofka.reto.Domain.Transporte.Transporte;

public class AgregarConductorUseCase extends UseCase<RequestCommand<AgregarConductor>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarConductor> agregarConductorRequestCommand) {
        var command=agregarConductorRequestCommand.getCommand();
        var transporte= Transporte.from(command.getTransporteID(),retrieveEvents(command.getConductorID().value()));

        transporte.AgregarConductor(
                command.getConductorID(),
                command.getNombre(),
                command.getTelefono(),
                command.getEmail(),
                command.getLocalidad()
        );

        emit().onResponse(new ResponseEvents(transporte.getUncommittedChanges()));
    }
}
