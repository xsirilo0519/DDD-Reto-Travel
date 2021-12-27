package co.com.sofka.reto.UseCases.Transporte;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.reto.Domain.Transporte.Commands.AgregarConductor;
import co.com.sofka.reto.Domain.Transporte.Commands.AgregarVehiculo;
import co.com.sofka.reto.Domain.Transporte.Transporte;

public class AgregarVehiculoUseCase extends UseCase<RequestCommand<AgregarVehiculo>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarVehiculo> agregarVehiculoRequestCommand) {
        var command=agregarVehiculoRequestCommand.getCommand();
        var transporte= Transporte.from(command.getTransporteID(),retrieveEvents(command.getPlaca().value()));

        transporte.AgregarVehiculo(
                command.getPlaca(),
                command.getCapacidad(),
                command.getModelo()
        );

        emit().onResponse(new ResponseEvents(transporte.getUncommittedChanges()));

    }
}
