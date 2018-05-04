package xmls;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import models.Booking;
import service.BookingService;

public class XMLAccess {
	private static int USERS_LAST_ID = 0;
	
	private static final String BOOKSTORE_XML = "C:/Users/George/web/bookXml.xml";
	
	public static void AddNewBooking(String name, String desiredHour) throws JAXBException, IOException {
		File xml = new File(BOOKSTORE_XML);
		BookingService container;
		JAXBContext context = JAXBContext.newInstance(BookingService.class);
		
		// create bookings
        Booking book1 = new Booking();
        book1.setName(name);
        book1.setdesiredHour(desiredHour);

        
        if(xml.exists()){
        	Unmarshaller unmarshaller = context.createUnmarshaller();
        	container = (BookingService) unmarshaller.unmarshal(xml);
        } else{
        	container = new BookingService();
        }
        
        container.setBookingList(book1);
        
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(container,  xml);
	}
	
	public static ArrayList<Booking> getAllBookings() throws JAXBException{
		JAXBContext context = JAXBContext.newInstance(BookingService.class);
		// get variables from our xml file, created before
        System.out.println();
        System.out.println("Output from our XML File: ");
        Unmarshaller um = context.createUnmarshaller();
        BookingService bookstore2 = null;
		try {
			bookstore2 = (BookingService) um.unmarshal(new FileReader(
			        BOOKSTORE_XML));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ArrayList<Booking> list = bookstore2.getBookingList();
        for (Booking book : list) {
            System.out.println("Book: " + book.getName() + " from "
                    + book.getdesiredHour());
        }
        
        return list;
        
	}
	
}
