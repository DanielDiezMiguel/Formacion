package com.bosonit.BS2;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CiudadServiceImpl implements CiudadService{

    List<Ciudad> listaCiudades= new ArrayList<>();

    @Override
    public void addCiudad(Ciudad ciudad)
    {
        listaCiudades.add(ciudad);
    }

    @Override
    public List<Ciudad> getCiudades()
    {
        return listaCiudades;
    }
}
