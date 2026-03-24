package sheridan.tetervak.cardata.data;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CarRepository extends CrudRepository<Car, Long> {

    // fetch cars by brand
    Iterable<Car> findByBrand(@Param("brand") String brand);

    // fetch cars by model year
    Iterable<Car> findByModelYear(@Param("modelYear") int modelYear);

    // fetch cars by model year
    Iterable<Car> findByModelYearGreaterThan(@Param("modelYear") int modelYear);

    // fetch cars by model year
    @Query("select c from Car c where c.modelYear > :modelYear")
    Iterable<Car> findNewerThan(@Param("modelYear") int modelYear);

    // fetch cars by price
    Iterable<Car> findByPrice(@Param("price") int price);

    // fetch cars by brand and model year
    Iterable<Car> findByBrandAndModelYear(@Param("brand") String brand, @Param("modelYear") int modelYear);

    // fetch cars by brand and sort by price
    Iterable<Car> findByBrandOrderByPrice(@Param("brand") String brand);

}
