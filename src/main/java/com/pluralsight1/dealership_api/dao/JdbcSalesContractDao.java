package com.pluralsight1.dealership_api.dao;

import com.pluralsight1.dealership_api.model.SalesContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class JdbcSalesContractDao implements SalesContractDao{
    private DataSource dataSource;
    @Autowired
    public JdbcSalesContractDao(DataSource dataSource) {
            this.dataSource = dataSource;
        }
        @Override
        public List<SalesContract> getAll () {
            List<SalesContract> contracts = new ArrayList<>();
            String sql = "SELECT * FROM sales_contracts";
            try (
                    Connection conn = dataSource.getConnection();
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    ResultSet rs = stmt.executeQuery()
            ) {
                while (rs.next()) {
                    contracts.add(mapRowToSalesContract(rs));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return contracts;
        }

        @Override
        public SalesContract getById ( int id){
            String sql = "SELECT * FROM sales_contracts WHERE sales_contracts_id = ?";
            try (
                    Connection conn = dataSource.getConnection();
                    PreparedStatement stmt = conn.prepareStatement(sql)
            ) {
                stmt.setInt(1, id);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        return mapRowToSalesContract(rs);
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return null;
        }

        @Override
        public SalesContract insert (SalesContract contract){
            String sql = "INSERT INTO sales_contracts (customer_name, dealership_id, vehicle_id, `when`, total_price, monthly_payment) VALUES (?, ?, ?, ?, ?, ?)";
            try (
                    Connection conn = dataSource.getConnection();
                    PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
            ) {
                stmt.setString(1, contract.getCustomerName());
                stmt.setInt(2, contract.getDealershipId());
                stmt.setInt(3, contract.getVehicleId());
                stmt.setString(4, contract.getWhen());
                stmt.setString(5, contract.getTotalPrice());
                stmt.setString(6, contract.getMonthlyPayment());
                int affectedRows = stmt.executeUpdate();
                if (affectedRows == 0) {
                    throw new SQLException("Insert failed, no rows affected.");
                }
                try (ResultSet keys = stmt.getGeneratedKeys()) {
                    if (keys.next()) {
                        contract.setSalesContractsId(keys.getInt(1));
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return contract;
        }

        @Override
        public void update ( int id, SalesContract contract){
            String sql = "UPDATE sales_contracts SET customer_name=?, dealership_id=?, vehicle_id=?, `when`=?, total_price=?, monthly_payment=? WHERE sales_contracts_id=?";
            try (
                    Connection conn = dataSource.getConnection();
                    PreparedStatement stmt = conn.prepareStatement(sql)
            ) {
                stmt.setString(1, contract.getCustomerName());
                stmt.setInt(2, contract.getDealershipId());
                stmt.setInt(3, contract.getVehicleId());
                stmt.setString(4, contract.getWhen());
                stmt.setString(5, contract.getTotalPrice());
                stmt.setString(6, contract.getMonthlyPayment());
                stmt.setInt(7, id);
                stmt.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void delete ( int id){
            String sql = "DELETE FROM sales_contracts WHERE sales_contracts_id=?";
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
        private SalesContract mapRowToSalesContract (ResultSet rs) throws SQLException {
            return new SalesContract(
                rs.getInt("sales_contracts_id"),
                rs.getString("customer_name"),
                rs.getInt("dealership_id"),
                rs.getInt("vehicle_id"),
                rs.getString("when"),
                rs.getString("total_price"),
                rs.getString("monthly_payment")
        );
    }
}