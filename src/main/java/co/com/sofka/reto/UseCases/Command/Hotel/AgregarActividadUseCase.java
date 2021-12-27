package co.com.sofka.reto.UseCases.Command.Hotel;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.reto.Domain.Hotel.Command.AgregarActividad;
import co.com.sofka.reto.Domain.Hotel.Hotel;

public class AgregarActividadUseCase extends UseCase<RequestCommand<AgregarActividad>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarActividad> agregarActividadRequestCommand) {
        var command=agregarActividadRequestCommand.getCommand();
        var hotel= Hotel.from(command.getHotelID(),retrieveEvents(command.getActividadID().value()));

        hotel.AgregarActividad(
                command.getActividadID(),
                command.getDescripcion()
        );

        emit().onResponse(new ResponseEvents(hotel.getUncommittedChanges()));
    }
}
