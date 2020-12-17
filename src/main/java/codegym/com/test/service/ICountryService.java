package codegym.com.test.service;

import codegym.com.test.model.Country;

public interface ICountryService {
    Iterable<Country> findAll();
    Country findById(Long id);
}
