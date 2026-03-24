package sheridan.tetervak.cardata.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cars")
@Setter
@Getter
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Brand cannot be blank")
    private String brand;

    @NotBlank
    private String model;

    private String color;

    @JsonProperty("registration")
    private String registrationNumber;

    @JsonProperty("year")
    @Min(value = 1900, message = "Model year must be after 1900")
    @Max(value = 2050, message = "Model year must be before 2050")
    private int modelYear;

    @Min(value = 10, message = "Price must be at least 10")
    @Max(value = 100000, message = "Price must be at most 100000")
    private int price;

    public Car() {
    }

    public Car(String brand, String model, String color, String registrationNumber, int modelYear, int price, Owner owner) {
        super();
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.registrationNumber = registrationNumber;
        this.modelYear = modelYear;
        this.price = price;
        this.owner = owner;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner")
    private Owner owner;
}
