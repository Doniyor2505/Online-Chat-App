package service.implement;

import enums.Role;
import main.MainApp;
import model.User;
import service.DemonstrationService;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DemonstrationServiceImpl implements DemonstrationService {
public static Scanner scanner;


    @Override
    public void showUserMenu() {
        scanner = new Scanner(System.in);
        System.out.println("Not implemented yet!");
        for (User user : MainApp.users) {

        }



    }

    private void menuUser() {


    }

    @Override
    public void showAdminMenu() {


        while (true) {
            scanner = new Scanner(System.in);
            System.out.println("--------------------");
            adminMenu();
            System.out.println("--------------------");
            System.out.print("Select the option: => ");
            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    System.out.println(String.format("%1$-5s", "Id") +
                            String.format("%1$-10s", "First name") +
                            String.format("%1$-15s", "Last name") +
                            String.format("%1$-25s", "Email") +
                            String.format("%1$-15s", "Password") +
                            String.format("%1$-15s", "Role") +
                            String.format("%1$-15s", "Status")
                    );
                    for (User user : MainApp.users) {
                        if(user.getRole().equals(Role.USER)) {
                            System.out.println(user);
                        }
                    }
                    break;

                case 2:
                    while (true) {
                        try {
                            scanner = new Scanner(System.in);
                            System.out.print("Enter email address:");
                            String email = scanner.next();
                            User user = findByEmail(email);
                            if (user != null) {
                                user.deactivate();
                                System.out.println(user.getFirstname() + " has been blocked!");
                            } else {
                                System.out.println("User with " + email + " not found!");
                            }
                            break;
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3:
                    while (true) {
                        try {
                            scanner = new Scanner(System.in);
                            System.out.print("Enter email address:");
                            String email = scanner.next();
                            User user = findByEmail(email);
                            if (user != null) {
                                user.activate();
                                System.out.println(user.getFirstname() + " has been activated!");
                            } else {
                                System.out.println("User with " + email + " not found!");
                            }
                            break;
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                    break;
                case 4:
                    while (true) {
                        try {
                            scanner = new Scanner(System.in);
                            System.out.print("Enter email address:");
                            String email = scanner.next();
                            User user = findByEmail(email);
                            if (user != null) {
                                MainApp.users.remove(user);
                                System.out.println(user.getFirstname() + " has been deleted!");
                            } else {
                                System.out.println("User with " + email + " not found!");
                            }
                            break;
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                    break;

                case 5:
                    while (true) {
                        try {
                            System.out.print("Enter new password: ");
                            String password = scanner.next();
                            System.out.print("Confirm new password: ");
                            String confirmPassword = scanner.next();
                            if (password.equals(confirmPassword)) {
                                MainApp.currentUser.setPassword(password);
                                System.out.println("Password has been successfully changed.");
                                break;
                            } else {
                                System.out.println("Passwords didn't match. Please, try again!");
                            }
                        }catch (Exception exception){
                            exception.printStackTrace();
                        }
                    }
            }

        }


    }

    private User findByEmail(String email) {
        for (User user : MainApp.users) {
            if(user.getEmail().equals(email)){
                return user;
            }
        }
        return null;
    }

    private void adminMenu() {

        System.out.println("1. User list ");
        System.out.println("2. Block the user ");
        System.out.println("3. Activate blocked users ");
        System.out.println("4. User delete ");
        System.out.println("5. Change password ");

    }
}
