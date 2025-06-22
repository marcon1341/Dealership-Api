package com.pluralsight1.dealership_api.dao;

import com.pluralsight1.dealership_api.model.Dealership;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcDealershipDao implements DealershipDao {
    private DataSource dataSource;
    @Autowired
    public JdbcDealershipDao(DataSource dataSource){
        this.dataSource=dataSource;
    }
    @Override
    public List<Dealership> getAll() {
        List<Dealership> dealerships = new ArrayList<>();
        String sql = "SELECT * FROM dealerships";
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()
        ) {
            while (rs.next()) {
                Dealership d = new Dealership(
                    rs.getInt("dealership_id"),
                    rs.getString("name"),
                    rs.getString("address"),
                    rs.getString("phone")
                );
                dealerships.add(d);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dealerships;
    }
    @Override
    public Dealership getById(int id) {
        String sql = "SELECT * FROM dealerships WHERE dealership_id = ?";
        Dealership dealership = null;
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    dealership = new Dealership(
                            rs.getInt("dealership_id"),
                            rs.getString("name"),
                            rs.getString("address"),
                            rs.getString("phone")
                    );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dealership;
    }

    @Override
    public Dealership insert(Dealership dealership) {
        String sql = "INSERT INTO dealerships (name, address, phone) VALUES (?, ?, ?)";
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ) {
            stmt.setString(1, dealership.getName());
            stmt.setString(2, dealership.getAddress());
            stmt.setString(3, dealership.getPhone());
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Insert failed, no rows affected.");
            }
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    dealership.setDealershipId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dealership;
    }

    @Override
    public void update(int id, Dealership dealership) {
        String sql = "UPDATE dealerships SET name = ?, address = ?, phone = ? WHERE dealership_id = ?";
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setString(1, dealership.getName());
            stmt.setString(2, dealership.getAddress());
            stmt.setString(3, dealership.getPhone());
            stmt.setInt(4, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM dealerships WHERE dealership_id = ?";
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
