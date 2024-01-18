package com.springform.app.services;

import com.springform.app.models.domain.Country;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service
public class CountryServiceImpl implements CountryService{
    private final List<Country> list;

    public CountryServiceImpl(){
        this.list = Arrays.asList(
                new Country(1,"ES", "Spain"),
                new Country(2,"CO", "Colombia"),
                new Country(3,"VEN", "Venezuela"),
                new Country(4,"EC", "Ecuador"),
                new Country(5,"ARG", "Argentina"),
                new Country(6,"PE", "Peru")
        );
    }
    @Override
    public List<Country> list() {
        return list;
    }

    @Override
    public Country getForId(Integer id) {
        Country rs = null;
        for (Country country : this.list()){
            if (country.getId().equals(id)){
                rs = country;
                break;
            }
        }
        return rs;
    }
}
