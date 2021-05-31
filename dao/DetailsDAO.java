package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Library;
import model.WantBook;

public class DetailsDAO {

    public List<Library> detailsLibrary(String isbn) {
        List<Library> libraryList = new ArrayList<>();

     // 指定したISBNに応じたレコードを取得するSELECT文
        String sql =
                "SELECT * FROM library WHERE ISBN LIKE ? ORDER BY ISBN ASC";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }

        // DB接続
        try (Connection con =
                DBManager.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            // プレースホルダーに値をセット
            ps.setString(1,isbn + "%");

            // SELECT文を実行し、レコード取得
            ResultSet rs = ps.executeQuery();

            // 取得したレコードをLibraryインスタンスに設定し、ArrayListに格納
            while (rs.next()) {
                 isbn = rs.getString("isbn");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String publisher = rs.getString("publisher");
                String overview = rs.getString("overview");
                Library library = new Library(isbn, title, author, publisher, overview);
                libraryList.add(library);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return libraryList;
    }

    public List<WantBook> detailsWantBook(String isbn) {
        List<WantBook> wantBookList = new ArrayList<>();

     // 指定したISBNに応じたレコードを取得するSELECT文
        String sql =
                "SELECT * FROM library WHERE ISBN LIKE ? ORDER BY ISBN ASC";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }

        // DB接続
        try (Connection con =
                DBManager.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            // プレースホルダーに値をセット
            ps.setString(1,isbn + "%");

            // SELECT文を実行し、レコード取得
            ResultSet rs = ps.executeQuery();

            // 取得したレコードをwantBookインスタンスに設定し、ArrayListに格納
            while (rs.next()) {
                 isbn = rs.getString("isbn");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String publisher = rs.getString("publisher");
                String overview = rs.getString("overview");
                WantBook wantBook = new WantBook(isbn, title, author, publisher, overview);
                wantBookList.add(wantBook);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return wantBookList;
    }

}