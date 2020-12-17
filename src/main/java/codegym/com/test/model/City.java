package codegym.com.test.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "vui long nhap ten tp")
    private String name;
    @ManyToOne
    private Country country;
    @Min(value = 500, message = "dien tich nho qua")
    private Double area;
    @Min(value = 100, message = "dan so it qua")
    private Long population;
    private double GDP;
    private String description;

    public City() {
    }

    public City(Long id, @NotEmpty(message = "vui long nhap ten tp") String name, Country country, @Min(value = 500, message = "dien tich nho qua") Double area, @Min(value = 100, message = "dan so it qua") Long population, double GDP, String description) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.area = area;
        this.population = population;
        this.GDP = GDP;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public double getGDP() {
        return GDP;
    }

    public void setGDP(double GDP) {
        this.GDP = GDP;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
