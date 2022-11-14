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
                - can register
                - can login
                - can check-in (automated/manual)
                - can check-out (logout)
                - can view profile
            Admin:
                - can admit form
                - can view checked-in user
                - can view profile
    */
    
    public static void main(String[] args) {
        String failedPhoto = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
        String dummyPhoto = "uHPjbNjguc4semfVe7M8b6IgjKPd1AStPGjbdiDBFDO01zZCcbeMkOBpXb6OwyUv";
        String dummyNewPhoto = "uHPjbNjguf4semfVe7M8b6IgjKPd1AAAPGjbdiDBFDO01zZCcbeMkOBpXb6OwyUv";
        
        Admin admin1 = new Admin("admin_id", "email", "phoneNum", "adminName", true, "ttl", "alamat");
        
        User user1 = new User("001", "ehang@gmail.com", "+628127572075", "Rayhan Suryatama", true, "29-12-2001", "Purwokerto", "X001", dummyPhoto);
        User user2 = new User("002", "mhmmd.fzan02@gmail.com", "+62869696969", "Muhammad Fauzan", true, "29-2-2001", "Palembang", "X002", dummyPhoto);
        User user3 = new User("003", "rizkyaria@gmail.com", "+628123456789", "Rizky Aria Mu'alim", true, "09-05-2002", "Jakarta", "X003", dummyPhoto);
        
        int index = 0;
        user1.setNewPhoto(dummyNewPhoto);
        user2.setNewPhoto(dummyNewPhoto);
        user3.setNewPhoto(failedPhoto);
        System.out.println(user1.checkIn());
        
        System.out.println("Command Options: ");
        System.out.println("1: View Profile Admin");
        System.out.println("2: Admit Check-In User");
        System.out.println("3: View Checked-In User");
        System.out.println("0: Quit");
        Scanner scan = new Scanner(System.in);
        int pilihan = scan.nextInt();
        
        
        do {
        switch (pilihan){
            case 1:
                admin1.viewProFile();
                break;
            case 2:
                admin1.admitCheckIn(user1, index);
                index++;
                admin1.admitCheckIn(user2, index);
                index++;
                admin1.admitCheckIn(user3, index);
                index++;
                break;
            case 3:
                admin1.viewCheckedInUser(index);
                break;
            }
        System.out.println("Masukkan input: ");
        pilihan = scan.nextInt();
        } while (pilihan != 0);
    }
    
    
}
