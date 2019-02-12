package com.timwheeler.server;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
class WishlistController {
    private CarRepository repository;

    public WishlistController(CarRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/wishlist")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<Car> wishlist() {
        return repository.findAll().stream().filter(this::isOnWishlist).collect(Collectors.toList());
    }

    private boolean isOnWishlist(Car car) {
        return !car.getName().equals("Ferrari") &&
                !car.getName().equals("Lamborghini") &&
                !car.getName().equals("Subaru") &&
                !car.getName().equals("BMW");
    }

}



