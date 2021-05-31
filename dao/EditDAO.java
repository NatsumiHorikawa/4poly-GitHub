package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Library;

public class EditDAO {

	 //LibraryDB内のレコード更新メソッド
    public List<Library> updateLibrary(
    		String isbn,String title, String author, String publisher, String overview) {
        List<Library> libraryList = new ArrayList<>();

        //SQL文の準備
        String update_sql ="UPDATE library SET TITLE = ?,AUTHOR = ?,PUBLISHER = ?,OVERVIEW = ? WHERE ISBN = ?";
        String select_sql = "SELECT ISBN FROM library ORDER BY ISBN ASC";

        // DB接続
        try (	Connection con = DBManager.getConnection();
        		Statement st = con.createStatement();
        		PreparedStatement ps = con.prepareStatement(update_sql);){

        	ps.setString(1,title);
        	ps.setString(2,author);
        	ps.setString(3,publisher);
        	ps.setString(4,overview);
        	ps.setString(5,isbn);

        	// SELECT文を実行し、レコード更新
            ps.executeUpdate();

            // SELECT文を実行し、レコード取得
            ResultSet rs = st.executeQuery(select_sql);

            // 更新したレコードをLibraryインスタンスに設定し、ArrayListに格納
            while (rs.next()) {
                isbn = rs.getString("ISBN");
                title = rs.getString("TITLE");
                author = rs.getString("AUTHOR");
                publisher = rs.getString("PUBLISHER");
                overview = rs.getString("OVERVIEW");
                Library library = new Library(isbn, title, author, publisher, overview);
                libraryList.add(library);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return libraryList;
    }

}
