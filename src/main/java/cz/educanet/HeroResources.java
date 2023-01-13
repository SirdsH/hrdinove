package cz.educanet;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class HeroResources {
    public List<Publisher> getPublisher() {
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/superhero?user=root&password=");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT pub.publisher_name FROM superhero.publisher AS pub GROUP BY pub.publisher_name")
        ) {
            ArrayList<Publisher> publishers = new ArrayList<>();

            while (resultSet.next()) {
                publishers.add(new Publisher(resultSet.getString(1)));
            }

            return publishers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<SuperHero> getSuperHero() {
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/superhero?user=root&password=");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT sup.superhero_name, sup.full_name, ge.gender, ra.race, al.alignment FROM superhero.superhero AS sup JOIN superhero.gender as ge ON (ge.id = sup.gender_id) JOIN superhero.race as ra ON (ra.id = sup.race_id) JOIN superhero.alignment as al ON (al.id = sup.alignment_id)")
        ) {
            ArrayList<SuperHero> superHeroes = new ArrayList<>();

            while (resultSet.next()) {
                superHeroes.add(new SuperHero(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5)));
            }

            return superHeroes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
