package ui;

import hibernate.HibernateConfig;
import org.hibernate.Session;
import persistance.model.BookingModel;
import persistance.model.MenuModel;
import service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserUI
{
    // Scanner sc = new Scanner(System.in);
    private UserService userService = new UserService();

    private Session session = HibernateConfig.getSessionFactory().openSession();

    public void startUserManagement(Scanner sc)
    {
        int option = -1;

        while (option != 0)
        {
            displayMenu();
            option = sc.nextInt();
            sc.nextLine();

            switch (option)
            {
                case 1: newUserBooking(sc);
                break;

                case 2: showUserBookings(sc);
                break;

                case 3: cancelReservation(sc);
                break;

                case 4: order(sc);
                break;
            }


        }
    }

    private void displayMenu()
    {
        System.out.println("----------User Management-----------\n" +
                "1. Make new booking.\n" +
                "2. View all bookings. \n" +
                "3. Cancel booking. \n" +
                "4. Make an order. \n" +
                "0. Exit");
    }

    private void newUserBooking(Scanner sc)
    {
        System.out.println("Please enter booking date (YYYY-MM-DD): ");
        String bookingDate = sc.nextLine();

        System.out.println("Please enter booking time (HH:MM:SS): ");
        String bookingTime = sc.nextLine();

        System.out.println("Please enter number of seats: ");
        Integer nrOfPeople = sc.nextInt();
        sc.nextLine();
        //userService.tableManagement(nrOfPeople);
        System.out.println("Please enter phone number: ");
        String phoneNr = sc.nextLine();

        System.out.println("Please enter contact name: ");
        String clientName = sc.nextLine();

        userService.addBooking(bookingDate, bookingTime, phoneNr, nrOfPeople, clientName);
    }

    private void showUserBookings(Scanner sc)
    {
        System.out.println("Please enter phone number: ");
        String phoneNr = sc.nextLine();

        //System.out.println(userService.showUserBooking(phoneNr));

        List<BookingModel> bookings = userService.showUserBooking(phoneNr);

        for (BookingModel booking : bookings)
        {
            System.out.println(booking);
        }
    }

    private void cancelReservation(Scanner sc)
    {
        System.out.println("Please enter reservation id: ");
        Integer id = sc.nextInt();
        sc.nextLine();

        userService.cancelBooking(id);
    }

    private void order(Scanner sc)
    {
        int orderOption = -1;
        int total = 0;
        List orderedItems = new ArrayList();

        while (orderOption != 0)
        {
            userService.displayOrderMenu();

            System.out.println("Please choose what you would like to order: ");
            System.out.println("0. Checkout");
            orderOption = sc.nextInt();
            sc.nextLine();

            if (orderOption == 0)
                break;

            Object itemOrdered = userService.selectedItems(orderOption);

            orderedItems.add(itemOrdered);

            total = total + ((MenuModel) itemOrdered).getPrice();

            List<MenuModel> orderedCastedItems = (List<MenuModel>) orderedItems;


            for (int i = 0; i < orderedCastedItems.size(); i++)
            {
                // MenuModel menuModel = (MenuModel) itemOrdered;

                System.out.println("Item ordered: " +  orderedCastedItems.get(i).getDescription() + " " +
                        "Pret: " + orderedCastedItems.get(i).getPrice() + "\n");

            }

            System.out.println("Total: " + total + " RON");

            System.out.println();
        }

        System.out.println("Total comanda: " + total + " RON" + "\n");
    }
}
