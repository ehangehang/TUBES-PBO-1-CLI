/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.tubes;

import com.mycompany.tubes.classes.User;
import com.mycompany.tubes.classes.Admin;
import java.util.Scanner;
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
                - can login
                [v] can check-in (automated/manual)
                - can check-out (logout)
                - can view profile
            Admin:
                [v] can admit form
                [v] can view checked-in user
                [v] can view profile
    */
    
    public static void printMenu() {
        System.out.println("Command Options: ");
        System.out.println("1: View Profile Admin");
        System.out.println("2: View All User");
        System.out.println("3: View Checked-In User");
        System.out.println("4: Admit Check-In User");
        System.out.println("0: Quit");
    }
    
    public static void main(String[] args) {
        String failedPhoto = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
        String dummyPhoto = "uHPjbNjguc4semfVe7M8b6IgjKPd1AStPGjbdiDBFDO01zZCcbeMkOBpXb6OwyUv";
        String dummyNewPhoto = "uHPjbNjguf4semfVe7M8b6IgjKPd1AAAPGjbdiDBFDO01zZCcbeMkOBpXb6OwyUv";
        
        Admin admin1 = new Admin("admin_id", "email", "phoneNum", "adminName", true, "ttl", "alamat");
        
        User user1 = new User("001", "ehang@gmail.com", "+628127572075", "Rayhan Suryatama", true, "29-12-2001", "Purwokerto", "X001", dummyPhoto);
        User user2 = new User("002", "mhmmd.fzan02@gmail.com", "+62869696969", "Muhammad Fauzan", true, "29-2-2001", "Palembang", "X002", dummyPhoto);
        User user3 = new User("003", "rizkyaria@gmail.com", "+628123456789", "Rizky Aria Mu'alim", true, "09-05-2002", "Jakarta", "X003", dummyPhoto);
        
        user1.setNewPhoto(dummyNewPhoto);
        user2.setNewPhoto(dummyNewPhoto);
        user3.setNewPhoto(failedPhoto);
        
        admin1.addUser(user1);
        admin1.addUser(user2);
        admin1.addUser(user3);
        
        Scanner scan = new Scanner(System.in);
        printMenu();
        System.out.print("Pilih menu: "); int pilihan = scan.nextInt();
        
        do {
            switch (pilihan){
                case 1:
                    admin1.viewProFile();
                    break;
                case 2:
                    admin1.viewAllUser();
                    break;
                case 3:
                    admin1.viewCheckedInUser();
                    break;
                case 4:
                    admin1.admitCheckIn(user1);
                    admin1.admitCheckIn(user2);
                    admin1.admitCheckIn(user3);
                    break;
            }
            System.out.println("\n");
            printMenu();
            System.out.print("Pilih menu: "); pilihan = scan.nextInt();
        } while (pilihan != 0);
    }
    
    
}
