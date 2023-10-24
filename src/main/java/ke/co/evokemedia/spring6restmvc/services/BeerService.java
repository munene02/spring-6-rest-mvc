package ke.co.evokemedia.spring6restmvc.services;

import ke.co.evokemedia.spring6restmvc.model.Beer;

import java.util.List;
import java.util.UUID;

public interface BeerService {
    List<Beer> listBeers();

    Beer getBeerById(UUID id);

    Beer saveBeer(Beer beer);
}
