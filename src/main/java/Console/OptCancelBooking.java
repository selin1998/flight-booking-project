package Console;

import Controller.BookingController;
import DAO.Pair;
import Service.BookingService;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class OptCancelBooking implements Option {



    @Override
    public int optNumber() {
        return 4;
    }

    @Override
    public String text() {
        return "CANCEL THE BOOKING";
    }

    @Override
    public void execution(Pair pair) {
        System.out.println("Enter the booking id for canceling booking:");

        try{
            int id = console2.readInt();
            int seats= bc.getBookingbyPairandId(pair,id).passenger.size();
            String idFlight=  bc.getBookingbyId(id).flight.split("\\|")[1].trim();
            fc.inreaseSeats(idFlight,seats);
            bc.cancelBooking(id);
        }

        catch(InputMismatchException ex){
            console2.print("Your input is mismatching. Enter a number!!!\n");
        }

        catch (NoSuchElementException ex){
            console2.print("You do not have booking with such ID!!!\n");
        }


    }

    @Override
    public boolean isExit() {
        return false;
    }
}
