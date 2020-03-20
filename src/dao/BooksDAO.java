package dao;

import model.Books;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;

public class BooksDAO {
    public ArrayList<Books> findAll() {
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.connectDB();
        ArrayList<Books> books = new ArrayList<>();
        String sql = "SELECT book_id, book_name, book_author, categories.category_name, book_pages, book_year, book_price " +
                "FROM categories " +
                "INNER JOIN books " +
                "ON categories.category_id = books.book_category " +
                "ORDER BY book_id DESC";

        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int bookId = resultSet.getInt("book_id");
                String bookName = resultSet.getString("book_name");
                String bookAuthor = resultSet.getString("book_author");
                String bookCategory = resultSet.getString("category_name");
                int bookPages = resultSet.getInt("book_pages");
                int bookYear = resultSet.getInt("book_year");
                double bookPrice = resultSet.getDouble("book_price");

                Books book = new Books(bookId, bookName, bookAuthor, bookCategory, bookPages, bookYear, bookPrice);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (resultSet != null) resultSet.close(); } catch (Exception e) { e.printStackTrace(); }
            try { if (statement != null) statement.close(); } catch (Exception e) { e.printStackTrace(); }
            try { if (connection != null) connection.close(); } catch (Exception e) { e.printStackTrace(); }
        }

        return books;
    }

    public void addBook(String bookName, String bookAuthor, int bookCategory, int bookPages, int bookYear, double bookPrice) {
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.connectDB();
        String sql = "INSERT INTO books(book_name, book_author, book_category, book_pages, book_year, book_price) " +
                "VALUES(?,?,?,?,?,?)";

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, bookName);
            preparedStatement.setString(2, bookAuthor);
            preparedStatement.setInt(3, bookCategory);
            preparedStatement.setInt(4, bookPages);
            preparedStatement.setInt(5, bookYear);
            preparedStatement.setDouble(6, bookPrice);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (preparedStatement != null) preparedStatement.close(); } catch (Exception e) { e.printStackTrace(); }
            try { if (connection != null) connection.close(); } catch (Exception e) { e.printStackTrace(); }
        }
    }

    public void removeBook(int bookId) {
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.connectDB();
        String sql = "DELETE FROM books WHERE book_id = ?";

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, bookId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (preparedStatement != null) preparedStatement.close(); } catch (Exception e) { e.printStackTrace(); }
            try { if (connection != null) connection.close(); } catch (Exception e) { e.printStackTrace(); }
        }
    }
}
