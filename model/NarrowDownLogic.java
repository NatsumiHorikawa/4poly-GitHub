package model;

import java.util.List;

import dao.NarrowDownDAO;

public class NarrowDownLogic {

	//LibraryDB内を絞り込み検索するメソッド
    public List<Library> executeLibrary(String keyword){
        NarrowDownDAO dao = new NarrowDownDAO();
        List<Library> libraryList = dao.narrowDownLibrary(keyword);
        return libraryList;
   }

	public List<WantBook> executeWantBook(String keyword) {
		NarrowDownDAO dao = new NarrowDownDAO();
		List<WantBook> wantBookList = dao.narrowDownWantBook(keyword);
		return wantBookList;
	}
}