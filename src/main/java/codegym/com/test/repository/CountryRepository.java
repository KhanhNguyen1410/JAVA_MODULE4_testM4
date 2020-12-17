package codegym.com.test.repository;

import codegym.com.test.model.City;
import codegym.com.test.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    Country findAllById(Long id);
}
