package model;

import java.util.List;

import dao.EditDAO;

public class EditLogic {

	public List<Library> updateLibrary(
			String isbn,String title, String author, String publisher, String overview){
		EditDAO dao = new EditDAO();
		List<Library> libraryList = dao.updateLibrary(isbn,title,author,publisher,overview);

		return libraryList;
	}

}
