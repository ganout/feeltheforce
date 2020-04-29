package com.joda.feeltheforce.repository;

import com.joda.feeltheforce.entities.Planet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlanetRepository {

    private static final String URL_DATABASE = "jdbc:mysql://localhost:3306/star_wars?serverTimezone=Europe/Paris";
    private static final String SQL_USER = "joda";
    private static final String SQL_PASSWORD = "password44$";

    public List<Planet> findAll() {

    List<Planet> planets = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(URL_DATABASE, SQL_USER, SQL_PASSWORD);
            String request = "SELECT DISTINCT * FROM planet;";
            PreparedStatement statement = connection.prepareStatement(request);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {

                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Planet planet = new Planet(id, name);

                planets.add(planet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return planets;
    }

    public String findById(int planetID) {

        try {
            Connection connection = DriverManager.getConnection(URL_DATABASE, SQL_USER, SQL_PASSWORD);
            String request = "SELECT name FROM planet WHERE id=?;";
            PreparedStatement statement = connection.prepareStatement(request);
            statement.setInt(1, planetID);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            String name = resultSet.getString("name");

            return name;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}