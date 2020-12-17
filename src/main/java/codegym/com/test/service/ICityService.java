package codegym.com.test.service;

import codegym.com.test.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICityService {
    Page<City> findAll(Pageable pageable);

    Optional<City> findById(Long id);

    City save(City city);

    void remove(Long id);
    City findAllById(Long id);


}
