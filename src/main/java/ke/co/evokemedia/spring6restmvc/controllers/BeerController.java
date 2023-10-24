package ke.co.evokemedia.spring6restmvc.controllers;

import ke.co.evokemedia.spring6restmvc.model.Beer;
import ke.co.evokemedia.spring6restmvc.services.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {
    private final BeerService beerService;

    @GetMapping
    public List<Beer> listBeers(){
        return beerService.listBeers();
    }
    @GetMapping("/{beerId}")
    public Beer getBeerById(@PathVariable("beerId") UUID id){
        log.debug("Get Beer by Id in controller");
        return beerService.getBeerById(id);
    }

    @PostMapping
    public ResponseEntity createBeer(@RequestBody Beer beer){
        Beer savedBeer = beerService.saveBeer(beer);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beer/" + savedBeer.getId().toString());

        return new ResponseEntity(savedBeer, headers, HttpStatus.CREATED);
    }

    @PutMapping("{beerId}")
    public ResponseEntity updateBeer(@PathVariable("beerId") UUID id, @RequestBody Beer beer){
        Beer updatedBeer = beerService.updateBeer(id, beer);

        return new ResponseEntity(updatedBeer, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{beerId}")
    public ResponseEntity deleteBeer(@PathVariable("beerId") UUID id){
        beerService.deleteBeer(id);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
