package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Enter room number: ");
			int roomNumber = in.nextInt();
			System.out.print("check-in Date (dd/MM/yyyy): ");
			Date checkin = sdf.parse(in.next());
			System.out.print("check-out Date (dd/MM/yyyy): ");
			Date checkout = sdf.parse(in.next());

			Reservation reservation = new Reservation(roomNumber, checkin, checkout);
			System.out.println(reservation);

			System.out.println();
			System.out.println("Enter data to update the reservation");
			System.out.print("check-in Date (dd/MM/yyyy): ");
			checkin = sdf.parse(in.next());
			System.out.print("check-out Date (dd/MM/yyyy): ");
			checkout = sdf.parse(in.next());

			reservation.updateDates(checkin, checkout);
			System.out.println(reservation);
		}catch (ParseException e) {
			System.out.println("Invalid Date format");
		}catch (DomainException e) {
			System.out.println(e.getMessage());
		}catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}
		
		in.close();
	}

}
