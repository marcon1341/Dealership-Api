package com.pluralsight1.dealership_api.dao;

import com.pluralsight1.dealership_api.model.LeaseContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcLeaseContractDao implements LeaseContractDao{
    private final DataSource dataSource;

    @Autowired
    public JdbcLeaseContractDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<LeaseContract> getAll() {
        List<LeaseContract> contracts = new ArrayList<>();
        String sql = "SELECT * FROM lease_contracts";
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()
        ) {
            while (rs.next()) {
                LeaseContract contract = new LeaseContract(
                        rs.getInt("lease_contracts_id"),
                        rs.getString("customer_name"),
                        rs.getInt("dealership_id"),
                        rs.getInt("vehicle_id"),
                        rs.getTimestamp("when"),
                        rs.getBigDecimal("total_price"),
                        rs.getBigDecimal("monthly_payment")
                );
                contracts.add(contract);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contracts;
    }

    @Override
    public LeaseContract getById(int id) {
        String sql = "SELECT * FROM lease_contracts WHERE lease_contracts_id = ?";
        LeaseContract contract = null;
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    contract = new LeaseContract(
                            rs.getInt("lease_contracts_id"),
                            rs.getString("customer_name"),
                            rs.getInt("dealership_id"),
                            rs.getInt("vehicle_id"),
                            rs.getTimestamp("when"),
                            rs.getBigDecimal("total_price"),
                            rs.getBigDecimal("monthly_payment")
                    );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contract;
    }

    @Override
    public LeaseContract insert(LeaseContract contract) {
        String sql = "INSERT INTO lease_contracts (customer_name, dealership_id, vehicle_id, `when`, total_price, monthly_payment) VALUES (?, ?, ?, ?, ?, ?)";
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ) {
            stmt.setString(1, contract.getCustomerName());
            stmt.setInt(2, contract.getDealershipId());
            stmt.setInt(3, contract.getVehicleId());
            stmt.setTimestamp(4, contract.getWhen());
            stmt.setBigDecimal(5, contract.getTotalPrice());
            stmt.setBigDecimal(6, contract.getMonthlyPayment());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Inserting data error");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    contract.setLeaseContractsId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contract;
    }

    @Override
    public void update(int id, LeaseContract contract) {
        String sql = "UPDATE lease_contracts SET customer_name = ?, dealership_id = ?, vehicle_id = ?, `when` = ?, total_price = ?, monthly_payment = ? WHERE lease_contracts_id = ?";
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setString(1, contract.getCustomerName());
            stmt.setInt(2, contract.getDealershipId());
            stmt.setInt(3, contract.getVehicleId());
            stmt.setTimestamp(4, contract.getWhen());
            stmt.setBigDecimal(5, contract.getTotalPrice());
            stmt.setBigDecimal(6, contract.getMonthlyPayment());
            stmt.setInt(7, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM lease_contracts WHERE lease_contracts_id = ?";
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

