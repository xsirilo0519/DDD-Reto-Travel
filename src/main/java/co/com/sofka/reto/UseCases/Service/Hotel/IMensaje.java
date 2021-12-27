package co.com.sofka.reto.UseCases.Service.Hotel;

import co.com.sofka.reto.Domain.Experiencia.Values.ExperienciaID;
import co.com.sofka.reto.Domain.Hotel.Values.HotelID;

public interface IMensaje {
    boolean mensaje(String hotelID, String mensaje);
}
