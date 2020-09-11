package ui;

import ui.restaurant.MeniuUI;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AppUI
{
    // do not initialize from class, use constructor
    private Scanner sc = new Scanner(System.in);
    private UserUI userUI = new UserUI();
    private MeniuUI meniuUI = new MeniuUI();

    public void startApp()
    {
        int option = -1;

        while (option != 0)
        {
            option = getMeniuOption(Arrays.asList("1. User Management.", "2. Restaurant Management.", "0. Exit"), sc);

            switch (option)
            {
                case 1: userUI.startUserManagement(sc);
                break;

                case 2: meniuUI.startProductManagement(sc);
                break;
            }

        }
    }

    private Integer getMeniuOption(List<String> meniuri, Scanner sc) //utils class, make static
    {
        for (String meniu : meniuri)
        {
            System.out.println(meniu);
        }

        return sc.nextInt();
    }
}
