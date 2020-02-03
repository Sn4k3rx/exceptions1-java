package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner in = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter room number: ");
		int roomNumber = in.nextInt();
		System.out.print("check-in Date (dd/MM/yyyy): ");
		Date checkin = sdf.parse(in.next());
		System.out.print("check-out Date (dd/MM/yyyy): ");
		Date checkout = sdf.parse(in.next());
		
		if (!checkout.after(checkin)) {
			System.out.println("Error in reservation: check-out date must be after check-in date");
		}else {
			Reservation reservation = new Reservation(roomNumber, checkin, checkout);
			System.out.println(reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation");
			System.out.print("check-in Date (dd/MM/yyyy): ");
			checkin = sdf.parse(in.next());
			System.out.print("check-out Date (dd/MM/yyyy): ");
			checkout = sdf.parse(in.next());
			
			Date now = new Date(); 
			
			if (checkin.before(now) || checkout.before(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be future");
			}else if (checkout.after(checkin)) {
				System.out.println("Error in reservation: check-out date must be after check-in date");
			}else {
				reservation.updateDates(checkin, checkout);
				System.out.println(reservation);
			}
		}
		in.close();
	}

}
