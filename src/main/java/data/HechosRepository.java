package data;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import jakarta.ejb.LocalBean;
import jakarta.ejb.Singleton;
import models.*;

@Singleton
@LocalBean
public class HechosRepository {

    //private static final String URL = System.getenv("SPRING_DATASOURCE_URL");
    //private static final String USER = System.getenv("SPRING_DATASOURCE_USERNAME");
    //private static final String PASSWORD = System.getenv("SPRING_DATASOURCE_PASSWORD");

    //private String URL = System.getenv("URL");
    private String USER = System.getenv("USER");
    private String PASSWORD = System.getenv("PASSWORD");
    

    public void agregarHecho(Hecho hecho) {
        String query = "INSERT INTO hechos (descripcion) VALUES (?)";
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://172.30.20.163:31499/postgresql", USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, hecho.getDescription());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Hecho> listarHechos() {
        List<Hecho> hechos = new ArrayList<>();
        String query = "SELECT * FROM hechos";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
            	Hecho hecho = new Hecho();
                hecho.setDescription(resultSet.getString("descripcion"));
                hecho.setId(resultSet.getString("id"));
                Date fecha = resultSet.getDate("fecha");
                hecho.setDate(fecha);

                hechos.add(hecho);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hechos;
    }

    public Optional<Hecho> buscarHechoPorDescripcion(String descripcion) {
        String query = "SELECT * FROM hechos WHERE descripcion = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, descripcion);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Hecho hecho = new Hecho();
                    hecho.setDescription(resultSet.getString("descripcion"));
                    return Optional.of(hecho);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}