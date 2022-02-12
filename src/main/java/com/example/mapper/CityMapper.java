package com.example.mapper;

import com.example.bean.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

//@Mapper
public interface CityMapper {

    @Select("select * from city where id = #{id}")
    City getCityById(Integer id);


}
