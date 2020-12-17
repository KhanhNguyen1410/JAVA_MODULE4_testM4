package codegym.com.test.model;

import codegym.com.test.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class CountryFomatter implements Formatter<Country> {

    private ICountryService countryService;

    @Autowired
    public CountryFomatter(ICountryService countryService){
        this.countryService=countryService;
    }

    @Override
    public Country parse(String text, Locale locale) throws ParseException {
         return countryService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Country object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }


}
