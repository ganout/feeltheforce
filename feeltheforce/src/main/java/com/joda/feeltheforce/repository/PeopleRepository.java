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
            String request = "SELECT DISTINCT eye_color FROM people;";
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
            String request = "SELECT DISTINCT hair_color FROM people;";
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
            String request = "SELECT DISTINCT gender FROM people;";
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
}
