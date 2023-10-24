package ke.co.evokemedia.spring6restmvc.services;

import ke.co.evokemedia.spring6restmvc.model.Beer;

import java.util.UUID;

public interface BeerService {
    Beer getBeerById(UUID id);
}
