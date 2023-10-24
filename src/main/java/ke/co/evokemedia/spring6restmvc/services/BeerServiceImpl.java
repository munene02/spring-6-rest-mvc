package ke.co.evokemedia.spring6restmvc.services;

import ke.co.evokemedia.spring6restmvc.model.Beer;
import ke.co.evokemedia.spring6restmvc.model.BeerStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public Beer getBeerById(UUID id) {
        log.debug(("GET Beer Id in service was called"));
        return Beer.builder()
                .id(id)
                .version(1)
                .beerName("Nyatipa")
                .beerStyle(BeerStyle.ALE)
                .upc("12345")
                .price(new BigDecimal("12.99"))
                .quantityOnHand(200)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();
    }
}
