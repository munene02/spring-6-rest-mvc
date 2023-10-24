package ke.co.evokemedia.spring6restmvc.services;

import ke.co.evokemedia.spring6restmvc.model.Beer;
import ke.co.evokemedia.spring6restmvc.model.BeerStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
    private Map<UUID, Beer> beerMap;
    public  BeerServiceImpl() {
        this.beerMap = new HashMap<>();

        Beer beer1 = Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Nyatipa")
                .beerStyle(BeerStyle.ALE)
                .upc("12345")
                .price(new BigDecimal("12.99"))
                .quantityOnHand(200)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        Beer beer2 = Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Tusker")
                .beerStyle(BeerStyle.LAGER)
                .upc("123456")
                .price(new BigDecimal("16.99"))
                .quantityOnHand(250)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        Beer beer3 = Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Castle")
                .beerStyle(BeerStyle.STOUT)
                .upc("123457")
                .price(new BigDecimal("18.99"))
                .quantityOnHand(105)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        beerMap.put(beer1.getId(), beer1);
        beerMap.put(beer2.getId(), beer2);
        beerMap.put(beer3.getId(), beer3);
    }
    @Override
    public List<Beer> listBeers(){
        return new ArrayList<>(beerMap.values());
    }

    @Override
    public Beer getBeerById(UUID id) {
        log.debug(("GET Beer by Id in service was called"));
        return beerMap.get(id);
    }

    @Override
    public Beer saveBeer(Beer beer){
        Beer savedBeer = Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName(beer.getBeerName())
                .beerStyle(beer.getBeerStyle())
                .upc(beer.getUpc())
                .price(beer.getPrice())
                .quantityOnHand(beer.getQuantityOnHand())
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        beerMap.put(savedBeer.getId(), savedBeer);

        return savedBeer;
    }
}
