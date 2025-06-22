package com.pluralsight1.dealership_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConnectionTestController {
    @Autowired
    private javax.sql.DataSource dataSource;

    @GetMapping("/dbtest")
    public String testConnection() {
        try (java.sql.Connection conn = dataSource.getConnection()) {
            if (conn != null && !conn.isClosed()) {
                return "Database connection SUCCESS!";
            } else {
                return "Database connection FAILED!";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Database connection ERROR: " + e.getMessage();
        }
    }
}
