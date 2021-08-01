package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DBconnection implements ServletContextListener {

	static Connection connection = null;

	public void contextDestroyed(ServletContextEvent arg0) {
		try {
			System.out
					.println("-------E_com connection closed successfully------");

			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void contextInitialized(ServletContextEvent arg0) {
		ServletContext context = arg0.getServletContext();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost/dltag", "root", "root");
			context.setAttribute("connection", connection);
			System.out.println("-------connection opened successfully------");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return connection;
	}
}