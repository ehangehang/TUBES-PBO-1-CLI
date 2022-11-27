/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.tubes;

import com.mycompany.tubes.classes.User;
import com.mycompany.tubes.classes.Admin;
import java.util.*;
/**
 *
 * @author lenovo
 */
public class Driver {

    /*
    TODO:
        - Create 2 menus of Admin and User
        APP FLOW (User):
            - User register
            - User login
            - User checkin (input data foto baru)
            - dilihat kemiripan foto baru dengan foto lama
            - if kemiripan > 70% -> pass -> kirim boolean of admisison to admin
            - else -> isi form checkin
            - form checkin dikirim ke admin
            - admin admit form (bool of true or false)
            - check-in admitted
            - check-out -> back to menu
        APP FLOW (Admin):
            - Admin register instance
            - Admin login
            - Admin view forms and admit
            - Admin view checked-in user
            - Admin view profile
            - can logout -> exit program
        USERS:
            User:
                [v] (with constructor) can register
                [v] can login
                [v] can check-in (automated/manual)
                - can check-out (logout)
                - can view profile
            Admin:
                [v] can admit form
                [v] can view checked-in user
                [v] can view profile
    */
    
    public static void printMainMenu() {
        System.out.println("Command Options:");
        System.out.println("1. Login As Admin");
        System.out.println("2. Login As User");
        System.out.println("0. Quit");
    }
    
    public static void printMenuAdmin() {
        System.out.println("Command Options: ");
        System.out.println("1. View Profile Admin");
        System.out.println("2. View All User");
        System.out.println("3. View Checked-In User");
        System.out.println("4. Admit Check-In User");
        System.out.println("5. Logout");
    }
    
    public static void printMenuUser() {
        System.out.println("Command Options:");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Check-In");
        System.out.println("4. Check-Out (Logout)");
        System.out.println("5. View Profile");
    }
    
    public static void registerUser(User[] dbUsers) {
         // Register User
        Random rand = new Random();
        Scanner scanRegist = new Scanner(System.in);
        String registEmail;
        String registTelp;
        String registName;
        String registGender;
        String registTl;
        String registAddress;
        String registInstID;
        String registPhoto;
        for (int i = 0; i < 20; i++) {
            if ("?".equals(dbUsers[i].getUserId())) {
                System.out.print("Email        : "); registEmail = scanRegist.nextLine();
                System.out.print("No. Telp     : "); registTelp = scanRegist.nextLine();
                System.out.print("Nama         : "); registName = scanRegist.nextLine();
                System.out.print("Gender (L/P) : "); registGender = scanRegist.nextLine();
                System.out.print("Tanggal Lahir: "); registTl = scanRegist.nextLine();
                System.out.print("Alamat       : "); registAddress = scanRegist.nextLine();
                System.out.print("ID Instansi  : "); registInstID = scanRegist.nextLine();
                System.out.print("Foto Diri    : "); registPhoto = scanRegist.nextLine();
                boolean gender = false;
                if ("L".equals(registGender)) {
                    gender = true;
                }
                dbUsers[i] = new User(
                        String.valueOf(rand.nextInt(101)), 
                        registEmail, 
                        registTelp, 
                        registName, 
                        gender, 
                        registTl, 
                        registAddress, 
                        registInstID, 
                        registPhoto
                );
                break;
            }
        }
    }
    
    public static User loginUser(User[] dbUsers, String email) {
        for (int i = 0; i < dbUsers.length; i++) {
            if (dbUsers[i].getEmail() == null ? email == null : dbUsers[i].getEmail().equals(email)) {
                return dbUsers[i];
            }
        }
        return new User();
    }
    
    public static void main(String[] args) {
        String failedPhoto = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
        String dummyPhoto = "uHPjbNjguc4semfVe7M8b6IgjKPd1AStPGjbdiDBFDO01zZCcbeMkOBpXb6OwyUv";
        String dummyNewPhoto = "uHPjbNjguf4semfVe7M8b6IgjKPd1AAAPGjbdiDBFDO01zZCcbeMkOBpXb6OwyUv";
        
        // User(s) database
        User[] users = new User[20];
        int indexer = 0;
        for (int i = 0; i < 20; i++) {
            users[i] = new User();
        }
        
        // Admin
        Admin admin1 = new Admin("admin_id", "email", "phoneNum", "adminName", true, "ttl", "alamat");
        
        // Main Menu
        Scanner scanMain = new Scanner(System.in);
        printMainMenu();
        System.out.print("Pilih menu: "); int menuMain = scanMain.nextInt();
        do {
            switch(menuMain) {
                // Admin Menu
                case 1:
                    Scanner scanAdmin = new Scanner(System.in);
                    printMenuAdmin();
                    System.out.print("Pilih menu admin: "); int menuAdmin = scanAdmin.nextInt();
                    do {
                        switch (menuAdmin){
                            // View Profile
                            case 1:
                                admin1.viewProfile();
                                break;
                            // View All User
                            case 2:
                                admin1.viewAllUser();
                                break;
                            // View Checked-In User
                            case 3:
                                admin1.viewCheckedInUser();
                                break;
                            // Admit Check-In User
                            case 4:
                                // loop through array of User
                                for (int i = 0; i < users.length; i++) {
                                    if (users[i].getUserId() != null){
                                        admin1.admitCheckIn(users[i]);
                                    }
                                }
//                                admin1.admitCheckIn(user1);
//                                admin1.admitCheckIn(user2);
//                                admin1.admitCheckIn(user3);
                                break;
                        }
                        System.out.println("");
                        printMenuAdmin();
                        System.out.print("Pilih menu admin: "); menuAdmin = scanAdmin.nextInt();
                    } while (menuAdmin != 5);
                    break;
                // User Menu
                case 2:
                    Scanner scanUser = new Scanner(System.in);
                    printMenuUser();
                    System.out.print("Pilih menu user: "); int menuUser = scanUser.nextInt();
                    User userCurr = new User();
                    do {
                        switch (menuUser) {
                            // Register
                            case 1:
                                registerUser(users);
                                admin1.addUser(users[indexer]);
                                indexer++;
//                                for (int i = 0; i < 5; i++) {
//                                    users[i].displayInfo();
//                                }
                                break;
                            // Login
                            case 2:
                                Scanner scanUserEmail = new Scanner(System.in);
                                System.out.print("Email: "); String email = scanUserEmail.nextLine();
                                userCurr = loginUser(users, email);
//                                userCurr.displayInfo();
                                break;
                            // Check-In
                            case 3:
                                Scanner scanNewPhoto = new Scanner(System.in);
                                System.out.print("Selfie: "); String newPhoto = scanNewPhoto.nextLine();
                                userCurr.setNewPhoto(newPhoto);
                                userCurr.checkIn();
                                admin1.admitCheckIn(userCurr);
                                break;
                            // View Profile
                            case 5:
                                userCurr.displayInfo();
                                break;
                        }
                        System.out.println("");
                        printMenuUser();
                        System.out.print("Pilih menu user: "); menuUser = scanUser.nextInt();
                    } while (menuUser != 4);
                    break;

            }
            System.out.println("");
            printMainMenu();
            System.out.print("Pilih menu: "); menuMain = scanMain.nextInt();
        } while (menuMain != 0);
        
        /*
        User user1 = new User("001", "ehang@gmail.com", "+628127572075", "Rayhan Suryatama", true, "29-12-2001", "Purwokerto", "X001", dummyPhoto);
        User user2 = new User("002", "mhmmd.fzan02@gmail.com", "+62869696969", "Muhammad Fauzan", true, "29-2-2001", "Palembang", "X002", dummyPhoto);
        User user3 = new User("003", "rizkyaria@gmail.com", "+628123456789", "Rizky Aria Mu'alim", true, "09-05-2002", "Jakarta", "X003", dummyPhoto);
        
        user1.setNewPhoto(dummyNewPhoto);
        user2.setNewPhoto(dummyNewPhoto);
        user3.setNewPhoto(failedPhoto);
        
        admin1.addUser(user1);
        admin1.addUser(user2);
        admin1.addUser(user3);
        */
    }
    
    
}
