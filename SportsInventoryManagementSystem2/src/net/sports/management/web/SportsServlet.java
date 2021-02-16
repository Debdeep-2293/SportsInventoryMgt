package net.sports.management.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sports.management.dao.SportsDAO;
import net.sports.management.model.Sports;

/**
 * SportsServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @email IIMD
 */

//@WebServlet("/")
public class SportsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SportsDAO userDAO;
	
	public void init() {
		userDAO = new SportsDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/Indexcontroller":
				showHomePage(request, response);
				break;
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertUser(request, response);
				break;
			case "/delete":
				deleteUser(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
			case "/search":
				searchUser(request, response);
				break;
			default:
				listUser(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Sports> listUser = userDAO.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String productid = request.getParameter("productid");
		Sports existingUser = userDAO.selectUser(productid);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);

	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
				String productid = request.getParameter("productid");
       			String product = request.getParameter("product");
                String model = request.getParameter("model");
                String manufacturer = request.getParameter("manufacturer");
                String typecode = request.getParameter("typecode");
                Double msrp = Double.parseDouble(request.getParameter("msrp"));
                Double unitcost = Double.parseDouble(request.getParameter("unitcost"));
                Double discountrate = Double.parseDouble(request.getParameter("discountrate"));
                int stockqty = Integer.parseInt(request.getParameter("stockqty"));
				
		Sports newUser = new Sports(productid,product, model, manufacturer, typecode, msrp, unitcost, discountrate, stockqty);
		userDAO.insertUser(newUser);
		response.sendRedirect("list");
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		        		String productid = request.getParameter("productid");
                        String product = request.getParameter("product");
                        String model = request.getParameter("model");
                        String manufacturer = request.getParameter("manufacturer");
                        String typecode = request.getParameter("typecode");
                        Double msrp = Double.parseDouble(request.getParameter("msrp"));
                        Double unitcost = Double.parseDouble(request.getParameter("unitcost"));
                        Double discountrate = Double.parseDouble(request.getParameter("discountrate"));
                        int stockqty = Integer.parseInt(request.getParameter("stockqty"));

		Sports book = new Sports(productid, product, model, manufacturer, typecode, msrp, unitcost, discountrate, stockqty);
		userDAO.updateUser(book);
		response.sendRedirect("list");
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String productid = request.getParameter("productid");
		userDAO.deleteUser(productid);
		response.sendRedirect("list");
	}
	
	private void searchUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("reached here");
		String productid = request.getParameter("productid");
		System.out.println("productid: " + productid);
		//response.sendRedirect("list");
		
		List<Sports> searchUser = userDAO.searchUser(productid);
		request.setAttribute("searchUser", searchUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-search.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showHomePage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("homepage.html");
		dispatcher.forward(request, response);
	}
}
