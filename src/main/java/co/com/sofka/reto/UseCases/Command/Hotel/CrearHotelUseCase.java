package co.com.sofka.reto.UseCases.Command.Hotel;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.reto.Domain.Hotel.Command.CrearHotel;
import co.com.sofka.reto.Domain.Hotel.Hotel;

public class CrearHotelUseCase extends UseCase<RequestCommand<CrearHotel>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearHotel> crearHotelRequestCommand) {
        var command=crearHotelRequestCommand.getCommand();
        var Hotel=new Hotel(command.getHotelID(),command.getNombre());
        emit().onResponse(new ResponseEvents(Hotel.getUncommittedChanges()));
    }
}
