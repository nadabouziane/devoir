package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.sql.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class OrderProcessor {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/devoir";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Nadoua2004";

    public static void main(String[] args) throws Exception {
        JSONArray inputOrders = JSONReader.readInputFile("data/input.json");
        JSONArray outputOrders = new JSONArray();
        JSONArray errorOrders = new JSONArray();

        // Connexion à la base de données
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            for (int i = 0; i < inputOrders.length(); i++) {
                JSONObject order = inputOrders.getJSONObject(i);
                int customerId = order.getInt("customer_id");

                if (isCustomerExists(connection, customerId)) {
                    saveOrderToDatabase(connection, order);
                    outputOrders.put(order);
                } else {
                    errorOrders.put(order);
                }
            }
        }

        // Écrire les fichiers output.json et error.json
        writeFile("data/output.json", outputOrders);
        writeFile("data/error.json", errorOrders);
    }

    private static boolean isCustomerExists(Connection connection, int customerId) throws SQLException {
        String query = "SELECT COUNT(*) FROM customer WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, customerId);
            try (ResultSet rs = stmt.executeQuery()) {
                rs.next();
                return rs.getInt(1) > 0;
            }
        }
    }

    private static void saveOrderToDatabase(Connection connection, JSONObject order) throws SQLException {
        String query = "INSERT INTO `order` (id, date, amount, customer_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, order.getInt("id"));
            stmt.setDate(2, Date.valueOf(order.getString("date")));
            stmt.setDouble(3, order.getDouble("amount"));
            stmt.setInt(4, order.getInt("customer_id"));
            stmt.executeUpdate();
        }
    }

    private static void writeFile(String filePath, JSONArray data) throws IOException {
        // Clear the file or create it if it doesn't exist
        Files.write(Paths.get(filePath), new byte[0]); // Clear the file content before writing new data
        Files.write(Paths.get(filePath), data.toString(4).getBytes());
    }
}