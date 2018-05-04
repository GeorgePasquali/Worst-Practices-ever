package models;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement
//If you want you can define the order in which the fields are written
//Optional
@XmlType(propOrder = {  "name", "desiredHour"})
public class Booking {

 private String name;
 private String desiredHour;

 // If you like the variable name, e.g. "name", you can easily change this
 // name for your XML-Output:
 @XmlElement(name = "title")
 public String getName() {
     return name;
 }

 public void setName(String name) {
     this.name = name;
 }

 public String getdesiredHour() {
     return desiredHour;
 }

 public void setdesiredHour(String author) {
     this.desiredHour = author;
 }


}