package model;

import java.util.List;

import dao.ListDAO;

public class GetWantBookLogic {

    public List<WantBook> execute() {
        ListDAO dao = new ListDAO();
        List<WantBook> wantBookList = dao.findAllWantBook();
        return wantBookList;

    }
}