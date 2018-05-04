	package Controllers;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import models.Booking;
import service.BookingService;
import xmls.XMLAccess;

/**
 * Servlet implementation class Bookings
 */
@WebServlet("/Bookings")
public class Bookings extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String BOOKSTORE_XML = "C:/Users/George/web/bookXml.xml";
    /**
     * @throws JAXBException 
     * @see HttpServlet#HttpServlet()
     */
    public Bookings() throws JAXBException, IOException {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ArrayList<Booking> list = XMLAccess.getAllBookings();

            
	          PrintWriter out = response.getWriter();
			 response.setContentType("text/html");
		  		response.setCharacterEncoding("UTF-8");
		  		
		  		out.append("<html><head><meta http-equiv='Content-Type' content='text/html; charset=ISO-8859-1'><link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'><!-- jQuery library --><script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script><!-- Latest compiled JavaScript --><script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script><title>Insert title here</title></head><body><nav class='navbar navbar-default'>  <div class='container-fluid'><!-- Brand and toggle get grouped for better mobile display -->    <div class='navbar-header'><button type='button' class='navbar-toggle collapsed' data-toggle='collapse' data-target='#bs-example-navbar-collapse-1' aria-expanded='false'>    <span class='sr-only'>Toggle navigation</span>     <span class='icon-bar'></span>  <span class='icon-bar'></span> <span class='icon-bar'></span>      </button>      <a class='navbar-brand' href='#'>Stoilov</a>    </div>    <!-- Collect the nav links, forms, and other content for toggling -->    <div class='collapse navbar-collapse' id='bs-example-navbar-collapse-1'>     <ul class='nav navbar-nav'>       <li class='active'><a href='Home'>Home <span class='sr-only'>(current)</span></a></li> <li class='dropdown'>    <a href='#' class='dropdown-toggle' data-toggle='dropdown' role='button' aria-haspopup='true' aria-expanded='false'>Bookings <span class='caret'></span></a>          <ul class='dropdown-menu'>           <li><a href='meetings'>Book a Meeting</a></li>      <li><a href='Bookings'>View All Bookings</a></li>    <li><a href='#'>Something else here</a></li><li role='separator' class='divider'></li>            <li><a href='#'>Separated link</a></li>  <li role='separator' class='divider'></li> <li><a href='#'>One more separated link</a></li></ul>        </li>     </ul>     <form class='navbar-form navbar-left'>        <div class='form-group'>       <input type='text' class='form-control' placeholder='Search For Bookings'>        </div><button type='submit' class='btn btn-default'>Submit</button></form><ul class='nav navbar-nav navbar-right'><li><a href='#'>Link</a></li><li class='dropdown'><a href='#' class='dropdown-toggle' data-toggle='dropdown' role='button' aria-haspopup='true' aria-expanded='false'>Bookings <span class='caret'></span></a><ul class='dropdown-menu'><li><a href='meetings'>Book a Meeting</a></li><li><a href='#'>Another action</a></li><li><a href='#'>Something else here</a></li><li role='separator' class='divider'></li><li><a href='#'>Separated link</a></li></ul></li></ul></div><!-- /.navbar-collapse --></div><!-- /.container-fluid --></nav>");
		  		
			for (Booking book : list) {
	          System.out.println("Book: " + book.getName() + " from "
	                    + book.getdesiredHour());
	          
	          
	          out.append("<div class='card'><div class='card-body'>");
	         out.append("	Name: " + book.getName() + ".\r\n<br>");
			out.append("	You successfully booked a meeting for " + book.getdesiredHour() +  ".\r\n<br><br>");
			out.append("</div></div>");
			
	        }

			out.append("</body></html>");
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//request.getRequestDispatcher("BookPage.jsp").forward(request, response);
	      // Set response content type

	      
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

}
