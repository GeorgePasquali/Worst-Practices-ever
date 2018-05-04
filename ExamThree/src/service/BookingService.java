package service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import models.Booking;

//This statement means that class "Bookstore.java" is the root-element of our example
@XmlRootElement()
public class BookingService {

  // XmLElementWrapper generates a wrapper element around XML representation
  @XmlElementWrapper
  @XmlElement(name = "booking")
  private ArrayList<Booking> list = new ArrayList<>();

  public void setBookingList(ArrayList<Booking> bookList) {
      this.list = bookList;
  }
  
  public void setBookingList(Booking booking) {
      this.list.add(booking);
  }

  public ArrayList<Booking> getBookingList() {
      return this.list;
  }

}