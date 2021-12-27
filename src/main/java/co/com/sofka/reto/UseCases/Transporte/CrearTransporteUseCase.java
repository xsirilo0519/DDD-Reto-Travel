package co.com.sofka.reto.UseCases.Transporte;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.reto.Domain.Hotel.Command.AgregarRecreacionista;
import co.com.sofka.reto.Domain.Transporte.Commands.CrearTransporte;
import co.com.sofka.reto.Domain.Transporte.Transporte;

public class CrearTransporteUseCase extends UseCase<RequestCommand<CrearTransporte>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearTransporte> crearTransporteRequestCommand) {
        var command=crearTransporteRequestCommand.getCommand();
        var transporte=new Transporte(command.getTransporteID(),command.getDescripcion());

        emit().onResponse(new ResponseEvents(transporte.getUncommittedChanges()));
    }
}
