package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Library;
import model.WantBook;

public class ListDAO {



    //LibraryDB内の全レコード取得メソッド
    public List<Library> findAllLibrary() {
        List<Library> libraryList = new ArrayList<>();

        // DB接続
        try (	Connection con = DBManager.getConnection();
        		Statement st = con.createStatement();) {

            // SELECT文
            String sql = "SELECT * FROM library ORDER BY ISBN ASC";

            // SELECT文を実行し、全レコード取得
            ResultSet rs = st.executeQuery(sql);

            // 取得したレコードをLibraryインスタンスに設定し、ArrayListに格納
            while (rs.next()) {
                String isbn = rs.getString("ISBN");
                String title = rs.getString("TITLE");
                String author = rs.getString("AUTHOR");
                String publisher = rs.getString("PUBLISHER");
                String overview = rs.getString("OVERVIEW");
                Library library = new Library(isbn, title, author, publisher, overview);
                libraryList.add(library);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return libraryList;
    }

  //WantBookDB内の全レコード取得メソッド
    public List<WantBook> findAllWantBook() {
    	List<WantBook> wantBookList = new ArrayList<>();

        // DB接続
        try (	Connection con = DBManager.getConnection();
        		Statement st = con.createStatement();) {

            // SELECT文
            String sql = "SELECT * FROM wantbook ORDER BY ISBN ASC";

            // SELECT文を実行し、全レコード取得
            ResultSet rs = st.executeQuery(sql);

            // 取得したレコードをWantBookインスタンスに設定し、ArrayListに格納
            while (rs.next()) {
            	String isbn = rs.getString("ISBN");
                String title = rs.getString("TITLE");
                String author = rs.getString("AUTHOR");
                String publisher = rs.getString("PUBLISHER");
                String overview = rs.getString("OVERVIEW");
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