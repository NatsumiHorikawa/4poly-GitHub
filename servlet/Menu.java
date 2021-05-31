package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GetLibraryLogic;
import model.GetWantBookLogic;
import model.Library;
import model.NarrowDownLogic;
import model.WantBook;

/**
 * Servlet implementation class Menu
 */
@WebServlet("/Menu")
public class Menu extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Menu() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // フォワードパス
        String forwardPath = "";

        // リクエストパラメータの取得
        String menu = request.getParameter("menu");

        switch (menu) {
        case "library": // もってるリストクリック時

            GetLibraryLogic getLibraryLogic =
                new GetLibraryLogic();
            List<Library> libraryList = getLibraryLogic.execute();

            //スコープに保存
            HttpSession session = request.getSession();
            session.setAttribute("libraryList", libraryList);

            //フォワードパスの設定
            forwardPath = "/WEB-INF/jsp/library.jsp";
            break;

        case "wantBook": // よみたいリストクリック時
            GetWantBookLogic getWantBookLogic =
            	new GetWantBookLogic();
            List<WantBook> wantBookList = getWantBookLogic.execute();

            //スコープに保存
            session = request.getSession();
            session.setAttribute("wantBookList", wantBookList);

            //フォワードパスの設定
            forwardPath = "/WEB-INF/jsp/wantBook.jsp";
            break;

        case "logout":  //ログアウトクリック時
            forwardPath = "/WEB-INF/jsp/logout.jsp";
            break;

        case "top": //TOPクリック時
            forwardPath = "/loginOK.jsp";
            break;

        default: // それ以外はメニュー画面に
            forwardPath = "/loginOK.jsp";
            break;
        }

        // フォワードの実行
        RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
        dispatcher.forward(request, response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");

        // フォワードパス
        String forwardPath = "";

        // リクエストパラメータの取得
        String keyword = request.getParameter("keyword");
        String from = request.getParameter("from");

        switch(from) {

        	case "library":
        		NarrowDownLogic ndLogic = new NarrowDownLogic();
        		List<Library> libraryList  = ndLogic.executeLibrary(keyword);

        		//スコープに保存
        		HttpSession session = request.getSession();
        		session.setAttribute("libraryList", libraryList);

        		forwardPath = "WEB-INF/jsp/library.jsp";
        		break;

        	case "wantBook":
        		ndLogic = new NarrowDownLogic();
        		List<WantBook> wantBookList = ndLogic.executeWantBook(keyword);

        		//スコープに保存
        		session = request.getSession();
        		session.setAttribute("wantBookList", wantBookList);

        		forwardPath = "WEB-INF/jsp/wantBook.jsp";
        		break;

        	default:
        		forwardPath = "/";
        		break;

        }
        // フォワードの実行
        RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
        dispatcher.forward(request, response);
    }
}

