package co.com.sofka.reto.UseCases.Service.Experiencia;

import co.com.sofka.reto.Domain.Experiencia.Values.ExperienciaID;

public interface IEnviarEmail {
    boolean send(ExperienciaID experienciaID, String email, String body);
}
