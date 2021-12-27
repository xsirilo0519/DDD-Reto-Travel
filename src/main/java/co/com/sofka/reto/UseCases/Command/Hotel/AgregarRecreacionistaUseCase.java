package co.com.sofka.reto.UseCases.Command.Hotel;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.reto.Domain.Hotel.Command.AgregarRecreacionista;
import co.com.sofka.reto.Domain.Hotel.Hotel;

public class AgregarRecreacionistaUseCase extends UseCase<RequestCommand<AgregarRecreacionista>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarRecreacionista> agregarRecreacionistaRequestCommand) {
        var command=agregarRecreacionistaRequestCommand.getCommand();
        var hotel= Hotel.from(command.getHotelID(),retrieveEvents(command.getRecreacionistaID().value()));

        hotel.AgregarRecreacionista(
                command.getRecreacionistaID(),
                command.getNombre(),
                command.getTelefono(),
                command.getEmail(),
                command.getLocalidad()
        );

        emit().onResponse(new ResponseEvents(hotel.getUncommittedChanges()));
    }
}
