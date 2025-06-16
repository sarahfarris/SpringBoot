package com.example.demo.dao;

import com.example.demo.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CityDao {
    private DataSource dataSource;

@Autowired
    public CityDao(DataSource dataSource){
    this.dataSource = dataSource;
}

//get all cities
    public List<City> getAllCities(){
    String query = "SELECT * FROM city";
    List<City> cities = new ArrayList<>();
    try(Connection connection = dataSource.getConnection();
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery()
    ) {
        while(rs.next()) {
            cities.add(new City(rs.getString("city"), rs.getInt("country_id")));
        }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return cities;
    }
}
