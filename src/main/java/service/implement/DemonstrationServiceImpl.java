package service.implement;

import enums.Role;
import main.MainApp;
import model.User;
import service.DemonstrationService;

import java.util.Scanner;

public class DemonstrationServiceImpl implements DemonstrationService {
public static Scanner scanner;


    @Override
    public void showUserMenu() {
        scanner = new Scanner(System.in);
        /**
         * Boshqa foydalanuvchilarga message jo’natish
         * O’zi egasi bo’lgan guruhga yoki o’zi a’zo bo’lgan guruhga message jo’natish .
         * Guruh yaratish va mavjud guruhlarga a’zo bolish uchun shu guruhnign egasidan rozilik so’rovini jo’natish
         * O’zguruhiga qoshilmoqchi bolganlar so’rovini tasdiqlash yoki rad etish
         * O’z parolini o’zgartirish.
         */


        System.out.println("====== User Menu ======");
        System.out.println("1.Send message");
        System.out.println("2.Send message to group");
        System.out.println("3.Group services");
        System.out.println("4.Change password");
        System.out.println("0.Sign Out");

        System.out.print("Menu: ");
        int choice = scanner.nextInt();
        switch (choice){

            case 0:
                MainApp.currentUser.setSignedIn(false);
                break;

            case 1:
                System.out.println("Kimga xat yozmoqchisiz?");
                String email = scanner.next();
                findByEmail(email);


                break;

            case 2:
                break;

            case 3:
                break;

            case 4:
                break;



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
