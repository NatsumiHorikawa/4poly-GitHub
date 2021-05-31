package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Library;
import model.WantBook;

public class NarrowDownDAO {

	public List<Library> narrowDownLibrary(String keyword) {
		List<Library> libraryList = new ArrayList<>();

		// 入力したキーワードからあいまい検索するSELECT文
		String sql = "SELECT * FROM library WHERE TITLE LIKE ? OR AUTHOR LIKE ? OR PUBLISHER LIKE ? ORDER BY ISBN ASC";

		// DB接続
		try (Connection con = DBManager.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {

			// プレースホルダーに値をセット
			ps.setString(1, "%" + keyword + "%"); //TITLEであいまい検索
			ps.setString(2, "%" + keyword + "%"); //AUTHORであいまい検索
			ps.setString(3, "%" + keyword + "%"); //PUBLISHERであいまい検索

			// 検索結果の取得
			ResultSet rs = ps.executeQuery();

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

	public List<WantBook> narrowDownWantBook(String keyword) {
		List<WantBook> wantBookList = new ArrayList<>();

		// 入力したキーワードからあいまい検索するSELECT文
		String sql = "SELECT * FROM wantbook WHERE TITLE LIKE ? OR AUTHOR LIKE ? OR PUBLISHER LIKE ? ORDER BY ISBN ASC";

		// DB接続
		try (Connection con = DBManager.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {

			// プレースホルダーに値をセット
			ps.setString(1, "%" + keyword + "%"); //TITLEであいまい検索
			ps.setString(2, "%" + keyword + "%"); //AUTHORであいまい検索
			ps.setString(3, "%" + keyword + "%"); //PUBLISHERであいまい検索

			// 検索結果の取得
			ResultSet rs = ps.executeQuery();

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