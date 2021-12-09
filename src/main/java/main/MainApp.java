package main;


import model.User;
import service.RegistrationService;
import service.implement.RegistrationServiceimpl;

import java.util.*;

public class MainApp {
    public static Scanner scanner;
    public static Set<User> users = new HashSet<>();


    static RegistrationService registrationService;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);


        while (true){
            showMainMenu();

            System.out.print("Operatsiyani tanlang: = > ");
            int choice = scanner.nextInt();

            switch (choice){

                case 1:
                    signIn();
                    break;

                case 2:
                    signUp();
                    break;

                case 0:
                    registrationService.exit();
                    return;




            }

        }




    }
    private static void signIn() {




    }

    private static void signUp() {
        registrationService = new RegistrationServiceimpl();
        boolean b = registrationService.signUp();

        if(b){
            System.out.println("Siz ro'yhatdan muvaffaqiyatli o'tdingiz");
        }else {
            System.out.println("Siz ro'yhatdan o'ta olamdingiz qaytadan urinib ko'ring!!!");
        }


    }

    private static void showMainMenu() {
        System.out.println("1. SignIn ");
        System.out.println("2. SignUp ");
        System.out.println("0. Exit ");
    }
}
