package model;

import java.util.List;

import dao.ListDAO;

public class GetLibraryLogic {

    public List<Library> execute(){
        ListDAO dao = new ListDAO();
        List<Library> libraryList = dao.findAllLibrary();
        return libraryList;
    }
}