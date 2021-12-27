package co.com.sofka.reto.UseCases.Experiencia;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.reto.Domain.Experiencia.Commands.AgregarGuia;
import co.com.sofka.reto.Domain.Experiencia.Commands.AgregarPlan;
import co.com.sofka.reto.Domain.Experiencia.Experiencia;

public class AgregarPlanUseCase extends UseCase<RequestCommand<AgregarPlan>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarPlan> agregarPlanRequestCommand) {
        var command=agregarPlanRequestCommand.getCommand();
        var experiencia= Experiencia.from(command.getExperienciaID(),retrieveEvents(command.getPlanID().value()));

        experiencia.AgregarPlan(
                command.getPlanID(),
                command.getDescripcion()
        );

        emit().onResponse(new ResponseEvents(experiencia.getUncommittedChanges()));

    }
}
