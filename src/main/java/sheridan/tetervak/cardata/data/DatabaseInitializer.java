package sheridan.tetervak.cardata.data;


import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class DatabaseInitializer {

    private final CarRepository carRepository;
    private final OwnerRepository ownerRepository;

    public DatabaseInitializer(
            CarRepository carRepository,
            OwnerRepository ownerRepository
    ) {
        this.carRepository = carRepository;
        this.ownerRepository = ownerRepository;
    }

    @PostConstruct
    public void initializeDatabase(){
        log.info("Initializing database...");
        // Add owner objects and save these to db
        Owner owner1 = new Owner("John" , "Johnson");
        Owner owner2 = new Owner("Mary" , "Robinson");
        ownerRepository.saveAll(List.of(owner1, owner2));

        carRepository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2023,  59000, owner1));
        carRepository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2020, 29000, owner2));
        carRepository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2022, 39000, owner2));

        // Fetch all cars and log to the console
        for (Car car : carRepository.findAll()) {
            log.info("brand: {}, model: {}", car.getBrand(), car.getModel());
        }
    }
}
