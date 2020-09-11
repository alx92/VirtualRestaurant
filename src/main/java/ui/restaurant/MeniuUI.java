package ui.restaurant;

import java.util.Scanner;

public class MeniuUI
{
    // private Scanner sc = new Scanner(System.in);

    public void startProductManagement(Scanner sc)
    {
        int option = -1;

        while (option != 0)
        {
            displayMenu();
            option = sc.nextInt();
            sc.nextLine();
        }
    }

    private void displayMenu()
    {
        System.out.println("----------Restaurant Management-----------\n" +
                "1. Food menu.\n" +
                "2. Drink menu \n" +
                "0. Exit");
    }
}
