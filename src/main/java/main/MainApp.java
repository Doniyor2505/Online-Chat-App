package main;


import enums.Role;
import model.Messages;
import model.User;
import service.DemonstrationService;
import service.RegistrationService;
import service.implement.DemonstrationServiceImpl;
import service.implement.RegistrationServiceimpl;

import java.util.*;

public class MainApp {
    public static Scanner scanner;
    public static Set<User> users = new HashSet<>();
    public static List<Messages> messages = new ArrayList<>();


    public static User currentUser;


    static RegistrationService registrationService;
    static DemonstrationService demonstrationService;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        users.add(new User(
                1L,
                "Ali",
                "Aliyev",
                "ali@gmail.com",
                "123",
                true,
                Role.ADMIN,
                false));

        users.add(new User(
                2L,
                "Vali",
                "Valiyev",
                "vali@gmail.com",
                "456",
                true,
                Role.USER,
                false));


        while (true){
            showMainMenu();

            System.out.print("Select the option: = > ");
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

        registrationService = new RegistrationServiceimpl();
        boolean success = registrationService.signIn();

        if(success){
            demonstrationService = new DemonstrationServiceImpl();
            while (currentUser.isSignedIn()) {
                switch (currentUser.getRole()) {

                    case USER:
                        demonstrationService.showUserMenu();
                        break;
                    case ADMIN:
                        demonstrationService.showAdminMenu();
                        break;
                }
            }
        }
    }

    private static void signUp() {
        registrationService = new RegistrationServiceimpl();
        boolean b = registrationService.signUp();

        if(b){
            System.out.println("Succes :)");
        }else {
            System.out.println("Registration Invalid :(");
        }


    }

    private static void showMainMenu() {
        System.out.println("1. SignIn ");
        System.out.println("2. SignUp ");
        System.out.println("0. Exit ");
    }
}
