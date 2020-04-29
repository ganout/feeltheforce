package com.joda.feeltheforce.repository;

import com.joda.feeltheforce.entities.People;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PeopleRepository {

    private static final String URL_DATABASE = "jdbc:mysql://localhost:3306/star_wars?serverTimezone=Europe/Paris";
    private static final String SQL_USER = "joda";
    private static final String SQL_PASSWORD = "password44$";

    public List<String> findAllEye() {

        List<String> eyes = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(URL_DATABASE, SQL_USER, SQL_PASSWORD);
            String request = "SELECT DISTINCT eye_color FROM people WHERE eye_color IS NOT NULL ORDER BY eye_color;";
            PreparedStatement statement = connection.prepareStatement(request);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {

                String eyeColor = resultSet.getString("eye_color");

                eyes.add(eyeColor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return eyes;
    }

    public List<String> findAllHairColors() {

        List<String> hairColors = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(URL_DATABASE, SQL_USER, SQL_PASSWORD);
            String request = "SELECT DISTINCT hair_color FROM people WHERE hair_color IS NOT NULL ORDER BY hair_color;";
            PreparedStatement statement = connection.prepareStatement(request);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {

                String hairColor = resultSet.getString("hair_color");

                hairColors.add(hairColor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hairColors;
    }

    public List<String> findAllGender() {

        List<String> genders = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(URL_DATABASE, SQL_USER, SQL_PASSWORD);
            String request = "SELECT DISTINCT gender FROM people WHERE gender IS NOT NULL ORDER BY gender;";
            PreparedStatement statement = connection.prepareStatement(request);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {

                String hairColor = resultSet.getString("gender");

                genders.add(hairColor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return genders;
    }

    public List<People> findAllPeople(int planetId, String gender, String eyeColor, String hairColor) {
        String planetIdNew;
        if (planetId == 0) {
            planetIdNew = "%";
        } else {
            planetIdNew = String.valueOf(planetId);
        }
        try {
            Connection connection = DriverManager.getConnection(URL_DATABASE, SQL_USER, SQL_PASSWORD);

            String request = "SELECT people.name AS name, planet.name AS planet, height, hair_color, eye_color, gender FROM people JOIN planet " +
                             "ON planet.id = people.planet_id WHERE planet_id LIKE ? AND gender LIKE ? " +
                             "AND eye_color LIKE ? AND hair_color LIKE ?;";
            PreparedStatement statement = connection.prepareStatement(request);
            statement.setString(1, planetIdNew);
            statement.setString(2, gender);
            statement.setString(3, eyeColor);
            statement.setString(4, hairColor);

            ResultSet resultSet = statement.executeQuery();

            List<People> people = new ArrayList<>();
            while(resultSet.next()) {
                String name = resultSet.getString("name");
                String planet = resultSet.getString("planet");
                int height = resultSet.getInt("height");
                String genderResult = resultSet.getString("gender");
                String hairColorResult = resultSet.getString("hair_color");
                String eyeColorResult = resultSet.getString("eye_color");
                people.add(new People(name, eyeColorResult, genderResult, hairColorResult, height,planet));
            }
            return people;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
