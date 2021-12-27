package co.com.sofka.reto.UseCases.Experiencia;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.reto.Domain.Experiencia.Commands.CrearExperiencia;
import co.com.sofka.reto.Domain.Experiencia.Experiencia;
import co.com.sofka.reto.Domain.Hotel.Command.CrearHotel;

public class CrearExperienciaUseCase extends UseCase<RequestCommand<CrearExperiencia>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearExperiencia> crearExperienciaRequestCommand) {
        var command=crearExperienciaRequestCommand.getCommand();
        var experiencia= new Experiencia(command.getExperienciaID(),command.getTransporteID(),command.getHotelID(),command.getPrecio());

        emit().onResponse(new ResponseEvents(experiencia.getUncommittedChanges()));
    }
}
