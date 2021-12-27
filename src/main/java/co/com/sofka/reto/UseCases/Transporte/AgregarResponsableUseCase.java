package co.com.sofka.reto.UseCases.Transporte;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.reto.Domain.Transporte.Commands.AgregarConductor;
import co.com.sofka.reto.Domain.Transporte.Commands.AgregarResponsable;
import co.com.sofka.reto.Domain.Transporte.Transporte;

public class AgregarResponsableUseCase extends UseCase<RequestCommand<AgregarResponsable>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<AgregarResponsable> agregarResponsableRequestCommand) {
        var command=agregarResponsableRequestCommand.getCommand();
        var transporte= Transporte.from(command.getTransporteID(),retrieveEvents(command.getResponsableID().value()));

        transporte.AgregarResponsable(
                command.getResponsableID(),
                command.getNombre(),
                command.getTelefono(),
                command.getEmail(),
                command.getLocalidad()
        );

        emit().onResponse(new ResponseEvents(transporte.getUncommittedChanges()));
    }
}
