package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Product;
import com.bean.User;
import com.dao.OrderDetailsDao;
import com.dao.OrdersDao;
import com.dao.ProductDao;
import com.dao.UserDao;

/**
 * Servlet implementation class FirstCryServlet
 */
@WebServlet("/FirstCryServlet")
public class FirstCryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String button = request.getParameter("button");
		HttpSession session = request.getSession();
		if (button == null) {
			try {
				List<String> cList = ProductDao.getAllCategories();

				session.setAttribute("cList", cList);
				ArrayList<Product> plist = ProductDao.GetAllProductDetails();
				request.setAttribute("pList", plist);
				request.getRequestDispatcher("Home.jsp").forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String button = request.getParameter("button");
		if (button.equals("Register")) {
			String name = request.getParameter("username");
			String email = request.getParameter("useremail");
			String password = request.getParameter("userpassword");
			boolean check = false;
			try {
				check = UserDao.checkEmailExists(email);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (!check) {
				User u = new User(name, email, password);
				boolean res = false;
				try {
					res = UserDao.register(u);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (res) {
					request.getRequestDispatcher("register.jsp").forward(request, response);
					out.print("Registered Successfully");
				} else {
					out.print("Registration  Failed");
				}
			} else {
				out.print("Account Already Exists");
			}

		} else if (button.equals("Login")) {
			String email = request.getParameter("loginemail");
			String pass = request.getParameter("loginpassword");
			try {
				if (UserDao.checkEmailExists(email)) {

					if (pass.equals(UserDao.getPwdWithEmail(email))) {

						String username = UserDao.UserName(email);
						int uid = UserDao.UserID(email);
						session.setAttribute("uid", uid);
						session.setAttribute("uname", username);
						List<String> cList = ProductDao.getAllCategories();

						session.setAttribute("cList", cList);
						ArrayList<Product> plist = ProductDao.GetAllProductDetails();
						request.setAttribute("pList", plist);
						request.getRequestDispatcher("loginhome.jsp").forward(request, response);
					}

					else {
						out.print("Check Password");
					}
				} else {
					out.print("Account Doesnt Exists");
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (button.equals("LogOut")) {

			request.getRequestDispatcher("logout.jsp").forward(request, response);
		}

		else if (button.equals("Go")) {
			String ct = request.getParameter("list");
			try {
				ArrayList<Product> plist = ProductDao.GetAllProductDetailsWithCategory(ct);
				request.setAttribute("pList", plist);
				request.getRequestDispatcher("Home.jsp").forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (button.equals("submit")) {
			String ct = request.getParameter("list");
			try {
				ArrayList<Product> plist = ProductDao.GetAllProductDetailsWithCategory(ct);
				request.setAttribute("pList", plist);
				request.getRequestDispatcher("loginhome.jsp").forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (button.equals("Add to Cart")) {
			HashMap<Product, Integer> hp = new HashMap<Product, Integer>();

			int Totalamount = 0;
			if (session.getAttribute("hp") == null) {
				String[] id = request.getParameterValues("itemid");
				String[] quantities = request.getParameterValues("quantity");

				for (int i = 0; i < quantities.length && i < id.length; i++) {

					if (Integer.parseInt(quantities[i]) != 0) {
						try {
							Product p = ProductDao.GetAllProductsWithID(Integer.parseInt(id[i]));
							hp.put(p, Integer.parseInt(quantities[i]));

						} catch (ClassNotFoundException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				}
				Set<Entry<Product, Integer>> entry = hp.entrySet();
				for (Entry<Product, Integer> e : entry) {
					Totalamount += (e.getKey().getPrice() * e.getValue());
					System.out.println(e);
				}
			}

			else {
				Totalamount = 0;
				hp = (HashMap<Product, Integer>) session.getAttribute("hp");
				String[] id = request.getParameterValues("itemid");
				String[] quantities = request.getParameterValues("quantity");

				for (int i = 0; i < quantities.length && i < id.length; i++) {

					if (Integer.parseInt(quantities[i]) != 0) {
						try {
							Product p = ProductDao.GetAllProductsWithID(Integer.parseInt(id[i]));
							hp.put(p, Integer.parseInt(quantities[i]));
						} catch (ClassNotFoundException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				}
				Set<Entry<Product, Integer>> entry = hp.entrySet();
				for (Entry<Product, Integer> e : entry) {
					Totalamount += (e.getKey().getPrice() * e.getValue());
				}

			}

			session.setAttribute("hp", hp);
			session.setAttribute("amount", Totalamount);
			request.getRequestDispatcher("cart.jsp").forward(request, response);

		} else if (button.equals("continue")) {
			int custId = (int) session.getAttribute("uid");
			int ta = (int) session.getAttribute("amount");
			Date d = new Date();
			Timestamp t = new java.sql.Timestamp(d.getTime());

			try {
				boolean res = OrdersDao.Generatebill(custId, ta, t);
				if (res) {
					HashMap<Product, Integer> hp = (HashMap<Product, Integer>) session.getAttribute("hp");
					Set<Entry<Product, Integer>> entry = hp.entrySet();
					int orderid = OrdersDao.GetOrderIDwithUserId(custId);
					for (Entry<Product, Integer> e : entry) {
						int pid = e.getKey().getId();
						int quantity = e.getValue();
						boolean res1 = OrderDetailsDao.AddOrderDetails(orderid, pid, quantity);
					}
					out.print("bill generated sucessfully");
					request.getRequestDispatcher("final.jsp").forward(request, response);
				} else {
					out.print("Bill not generated");
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
