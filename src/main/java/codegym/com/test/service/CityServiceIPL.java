package codegym.com.test.service;

import codegym.com.test.model.City;
import codegym.com.test.repository.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityServiceIPL implements ICityService{

    @Autowired
    private ICityRepository iCityRepository;


    @Override
    public Page<City> findAll(Pageable pageable) {
        return iCityRepository.findAll(pageable);
    }

    @Override
    public Optional<City> findById(Long id) {
        return iCityRepository.findById(id);
    }

    @Override
    public City save(City city) {
        return iCityRepository.save(city);
    }

    @Override
    public void remove(Long id) {
        iCityRepository.deleteById(id);
    }

    @Override
    public City findAllById(Long id) {
        return iCityRepository.findAllById(id);
    }
}
