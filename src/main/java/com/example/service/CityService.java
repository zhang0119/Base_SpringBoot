package com.example.service;

import com.example.bean.City;
import com.example.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    @Autowired
    private CityMapper cityMapper;

    public City getCityById(Integer id){
        return cityMapper.getCityById(id);
    }
}
