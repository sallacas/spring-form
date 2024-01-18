package com.springform.app.services;

import com.springform.app.models.domain.Country;

import java.util.List;

public interface CountryService {
    List<Country> list();
    Country getForId(Integer id);
}
