package co.com.sofka.reto.Domain.Hotel.Values;

import co.com.sofka.domain.generic.Identity;

public class RecreacionistaID extends Identity {
    public RecreacionistaID() {

    }

    private RecreacionistaID(String id) {
        super(id);
    }

    public static RecreacionistaID of(String id) {
        return new RecreacionistaID(id);

    }
}
