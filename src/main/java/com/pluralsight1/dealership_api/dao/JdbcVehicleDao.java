package com.pluralsight1.dealership_api.dao;

import com.pluralsight1.dealership_api.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcVehicleDao implements VehicleDao {
    private  DataSource dataSource;

    @Autowired
    public JdbcVehicleDao(DataSource dataSource){
        this.dataSource=dataSource;
    }


    @Override
    public List<Vehicle> getAll() {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM vehicles";

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()
        ) {
            while (rs.next()) {
                Vehicle v = new Vehicle(
                        rs.getInt("vehicle_id"),
                        rs.getString("vin"),
                        rs.getString("make"),
                        rs.getString("model"),
                        rs.getInt("year"),
                        rs.getString("color"),
                        rs.getString("price")
                );
                vehicles.add(v);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicles;
    }

        @Override
    public Vehicle getById(int id) {
        String sql =  "SELECT * FROM vehicles WHERE vehicle_id = ?";
        Vehicle vehicle = null;

        try(
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
            ){
              stmt.setInt(1, id);
              try(
                      ResultSet rs = stmt.executeQuery()){
                  if (rs.next()){
                      vehicle = new Vehicle(
                          rs.getInt("vehicle_id"),
                          rs.getString("vin"),
                          rs.getString("make"),
                          rs.getString("model"),
                          rs.getInt("year"),
                          rs.getString("color"),
                          rs.getString("price")
                  );
              }
          }

    } catch (SQLException e) {
            throw new RuntimeException(e);
    }
        return vehicle;
    }

    @Override
    public Vehicle insert(Vehicle vehicle) {
        String sql = "INSERT INTO vehicles (vin, make, model, year, color, price) VALUES (?, ?, ?, ?, ?, ?)";

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ) {
            stmt.setString(1, vehicle.getVin());
            stmt.setString(2, vehicle.getMake());
            stmt.setString(3, vehicle.getModel());
            stmt.setInt(4, vehicle.getYear());
            stmt.setString(5, vehicle.getColor());
            stmt.setString(6, vehicle.getPrice());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Inserting data error");
            }
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    vehicle.setVehicleId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicle;
    }

    @Override
    public void update(int id, Vehicle vehicle) {
        String sql = "UPDATE vehicles SET vin = ?, make=?, model=?, year=?, color=?, price=? WHERE vehicle_id = ?";
        try(
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
                ){
                stmt.setString(1,vehicle.getVin());
                stmt.setString(2, vehicle.getMake());
                stmt.setString(3, vehicle.getModel());
                stmt.setInt(4,vehicle.getYear());
                stmt.setString(5, vehicle.getColor());
                stmt.setString(6, vehicle.getPrice());
                stmt.setInt(7,id);

                stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM vehicles WHERE vehicle_id = ?";
        try(
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
            ){
            stmt.setInt(1, id);
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0){
                throw new SQLException("Deleting faild.");
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Vehicle> search(String make, String model, Integer minYear, Integer maxYear, String color, String minPrice, String maxPrice) {
        List<Vehicle> vehicles = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT * FROM vehicles WHERE 1=1");
        List<Object> params = new ArrayList<>();

        if (make != null) {
            sql.append(" AND make = ?");
            params.add(make);
        }
        if (model != null) {
            sql.append(" AND model = ?");
            params.add(model);
        }
        if (minYear != null) {
            sql.append(" AND year >= ?");
            params.add(minYear);
        }
        if (maxYear != null) {
            sql.append(" AND year <= ?");
            params.add(maxYear);
        }
        if (color != null) {
            sql.append(" AND color = ?");
            params.add(color);
        }
        if (minPrice != null) {
            sql.append(" AND CAST(price AS DECIMAL(10,2)) >= ?");
            params.add(minPrice);
        }
        if (maxPrice != null) {
            sql.append(" AND CAST(price AS DECIMAL(10,2)) <= ?");
            params.add(maxPrice);
        }

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql.toString())
        ) {
            for (int i = 0; i < params.size(); i++) {
                stmt.setObject(i + 1, params.get(i));
            }
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    vehicles.add(mapRowToVehicle(rs));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicles;
    }

    // Utility method for mapping a result set to a Vehicle
    private Vehicle mapRowToVehicle(ResultSet rs) throws SQLException {
        return new Vehicle(
                rs.getInt("vehicle_id"),
                rs.getString("vin"),
                rs.getString("make"),
                rs.getString("model"),
                rs.getInt("year"),
                rs.getString("color"),
                rs.getString("price")
        );
    }
}