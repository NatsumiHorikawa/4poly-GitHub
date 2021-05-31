package model;

import java.util.List;

import dao.DetailsDAO;

public class GetDetailsLogic {

    //LibraryDB内を検索するメソッド
    public List<Library> detailsLibrary(String isbn){
        DetailsDAO dao = new DetailsDAO();
        List<Library> libraryList = dao.detailsLibrary(isbn);
        return libraryList;
    }

  //WantBookDB内を検索するメソッド
    public List<WantBook> detailsWantBook(String isbn){
        DetailsDAO dao = new DetailsDAO();
        List<WantBook> wantBookList = dao.detailsWantBook(isbn);
        return wantBookList;
    }
}

