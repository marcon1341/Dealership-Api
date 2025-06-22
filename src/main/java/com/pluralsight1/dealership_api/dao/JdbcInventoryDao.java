package com.pluralsight1.dealership_api.dao;

import com.pluralsight1.dealership_api.model.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcInventoryDao implements InventoryDao{
    private final DataSource dataSource;

    @Autowired
    public JdbcInventoryDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Inventory> getAll() {
        List<Inventory> inventories = new ArrayList<>();
        String sql = "SELECT * FROM inventory";
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()
        ) {
            while (rs.next()) {
                Inventory inventory = new Inventory(
                        rs.getInt("inventory_id"),
                        rs.getInt("dealership_id"),
                        rs.getInt("vehicle_id")
                );
                inventories.add(inventory);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return inventories;
    }

    @Override
    public Inventory getById(int id) {
        String sql = "SELECT * FROM inventory WHERE inventory_id = ?";
        Inventory inventory = null;
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    inventory = new Inventory(
                            rs.getInt("inventory_id"),
                            rs.getInt("dealership_id"),
                            rs.getInt("vehicle_id")
                    );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return inventory;
    }

    @Override
    public Inventory insert(Inventory inventory) {
        String sql = "INSERT INTO inventory (dealership_id, vehicle_id) VALUES (?, ?)";
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ) {
            stmt.setInt(1, inventory.getDealershipId());
            stmt.setInt(2, inventory.getVehicleId());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Inserting inventory failed, no rows affected.");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    inventory.setInventoryId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return inventory;
    }

    @Override
    public void update(int id, Inventory inventory) {
        String sql = "UPDATE inventory SET dealership_id = ?, vehicle_id = ? WHERE inventory_id = ?";
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setInt(1, inventory.getDealershipId());
            stmt.setInt(2, inventory.getVehicleId());
            stmt.setInt(3, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM inventory WHERE inventory_id = ?";
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

