package co.com.sofka.reto.UseCases.Hotel;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.reto.Domain.Hotel.Command.AgregarHabitacion;
import co.com.sofka.reto.Domain.Hotel.Hotel;

public class AgregarHabitacionUseCase extends UseCase<RequestCommand<AgregarHabitacion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarHabitacion> agregarHabitacionRequestCommand) {
        var command=agregarHabitacionRequestCommand.getCommand();
        var hotel= Hotel.from(command.getHotelID(),retrieveEvents(command.getHabitacionID().value()));

        hotel.AgregarHabitacion(
                command.getHabitacionID(),
                command.getEstado(),
                command.getCant_cama()
        );

        emit().onResponse(new ResponseEvents(hotel.getUncommittedChanges()));
    }
}
