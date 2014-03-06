package edu.oit.cst236.lab4;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Homepage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().print(getWebPageFor(getName()));
	}
	
	public String getName() {
		return "Nick Ferraro";
	}

	public static void main(String[] args) throws Exception {
		Server server = new Server(Integer.valueOf(System.getenv("PORT")));
		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
		context.setContextPath("/");
		server.setHandler(context);
		context.addServlet(new ServletHolder(new Homepage()), "/*");
		server.start();
		server.join();
	}
	
	public final static String getWebPageFor(String name) {
		return "<!DOCTYPE html><html lang=\"en\"><head><meta name=\"generator\" content=\"HTML Tidy for HTML5 (experimental) for Windows https://github.com/w3c/tidy-html5/tree/c63cc39\" /><meta charset=\"utf-8\" /><title>Lab 4 - Complete</title><link rel=\"stylesheet\" type=\"text/css\" href=\"http://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/2.0.4/css/bootstrap.min.css\" /><link href='http://fonts.googleapis.com/css?family=Rock+Salt' rel='stylesheet' type='text/css'><link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'><style>html, body {height: 100%;text-align: center;} h1 {font-family: 'Rock Salt', cursive;font-size: 46px;line-height: 50px;} h3 {font-family: 'Rock Salt', cursive;font-size: 36px;line-height: 40px;} .name {font-family: 'Open Sans', sans-serif;font-size: 72px;line-height: 76px;margin-top: 40px;margin-bottom: 40px;color: blue;} .panel {position: relative;height: 250px;width: 900px;top: 50%;left: 50%;margin-top: -125px;margin-left: -450px;}</style><script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js\"></script><script type=\"text/javascript\"></script></head><body><div class=\"panel\"><span><h1>Congratulations</h1><div class=\"name\">" + name + "</div><h3>You Have Successfully Completed Lab 4</h3></span></div></body></html>";
	}
}
