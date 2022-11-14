/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tubes.classes;
import java.util.Scanner;
/**
 *
 * @author lenovo
 */
public class Admin {
    private String admin_id;
    public String email;
    public String phoneNum;
    public String adminName;
    private boolean gender;
    private String ttl;
    private String alamat;
    private User[] arrOfUser;
    private User[] arrOfUserAdmitted;
    private int index = 0;
    private int indexAdmitted = 0;
    
    public Admin(String admin_id, String email, String phoneNum,
            String adminName, boolean gender, String ttl, String alamat)
    {
        setAdmin(admin_id);
        setEmail(email);
        setPhoneNum(phoneNum);
        setAdminName(adminName);
        setGender(gender);
        setTtl(ttl);
        setAlamat(alamat);
        arrOfUser = new User[1000];
        arrOfUserAdmitted = new User[1000];
    }
    // Setter
    final public void setAdmin(String admin_id)
    {
        this.admin_id = admin_id;
    }
    final public void setEmail(String email)
    {
        this.email = email;
    }
    final public void setPhoneNum(String phoneNum)
    {
        this.phoneNum = phoneNum;
    }
    final public void setAdminName(String adminName)
    {
        this.adminName = adminName;
    }
    final public void setGender(boolean gender)
    {
        this.gender = gender;
    }
    final public void setTtl(String ttl)
    {
        this.ttl = ttl;
    }
    final public void setAlamat(String alamat)
    {
        this.alamat = alamat;
    }
    // Getter
    public String getAdminID()
    {
        return this.admin_id;
    }
    public String getEmail()
    {
        return this.email;
    }
    public String getPhoneNum()
    {
        return this.phoneNum;
    }
    public String getAdminName()
    {
        return this.adminName;
    }
    public String getGender()
    {
        if(this.gender==true)
        {
            return "Laki-Laki";
        }
        else if(this.gender==false)
        {
            return "Perempuan";
        }
        return "";
    }
    public String getTtl()
    {
        return this.ttl;
    }
    public String getAlamat()
    {
        return this.alamat;
    }
    // Function
    public void addUser(User data)
    {
        arrOfUser[index]=data;
        index++;
    }
    public void admitCheckIn(User data)
    {
        if(data.checkIn()){
            arrOfUserAdmitted[indexAdmitted]=data;
            indexAdmitted++;
        }else{
            System.out.println("--- Data User Check-In with form ---");
            System.out.println("User ID : "+data.getUserId());
            System.out.println("Photo : "+data.getPhoto());
            System.out.println("Email : "+data.getEmail());
            System.out.println("Phone : "+data.getPhone());
            System.out.println("Name : "+data.getName());
            //System.out.println("Gender : "+data.getGender());
            System.out.println("TTL : "+data.getTtl());
            System.out.println("Alamat : "+data.getAlamat());

            Scanner scan = new Scanner(System.in);
            System.out.println("Note: Pilih 1 jika 'iya' atau Pilih 0 jika 'tidak'");
            System.out.println("Apakah data ingin di admit? ");
            System.out.print("Hasil :  ");
            boolean hasil = scan.nextBoolean();
            if(hasil){
                arrOfUserAdmitted[indexAdmitted]=data;
                indexAdmitted++;
            }
        }
        
    }
    public void viewAllUser()
    {
        System.out.println("---- Data Semua User ----");
        for(int i=0; i < index; i++)
        {
            System.out.println("Data ke-"+(i+1));
            System.out.println("User ID : "+arrOfUser[i].getUserId());
            System.out.println("Photo : "+arrOfUser[i].getPhoto());
            System.out.println("Email : "+arrOfUser[i].getEmail());
            System.out.println("Phone : "+arrOfUser[i].getPhone());
            System.out.println("Name : "+arrOfUser[i].getName());
            System.out.println("Gender : "+arrOfUser[i].getGender());
            System.out.println("TTL : "+arrOfUser[i].getTtl());
            System.out.println("Alamat : "+arrOfUser[i].getAlamat());
            System.out.println("CHECK-IN STATUS : "+arrOfUser[i].checkIn());
        }
    }
    public void viewCheckedInUser()
    {
        System.out.println("---- Data Semua User Yang Sudah Check-In ----");
        for(int i=0; i < indexAdmitted; i++)
        {
            //if(arrOfUser[i].getName()!=null)
            
            //{
            System.out.println("Data ke-"+(i+1));
            System.out.println("User ID : "+arrOfUserAdmitted[i].getUserId());
            System.out.println("Photo : "+arrOfUserAdmitted[i].getPhoto());
            System.out.println("Email : "+arrOfUserAdmitted[i].getEmail());
            System.out.println("Phone : "+arrOfUserAdmitted[i].getPhone());
            System.out.println("Name : "+arrOfUserAdmitted[i].getName());
            System.out.println("Gender : "+arrOfUserAdmitted[i].getGender());
            System.out.println("TTL : "+arrOfUserAdmitted[i].getTtl());
            System.out.println("Alamat : "+arrOfUserAdmitted[i].getAlamat());
            //}else{
            //    break;
            //}
        }
    }
    public void viewProFile()
    {
        System.out.println("---- Data Admin ----");
        System.out.println("Admin ID : "+ this.getAdminID());
        System.out.println("Email : "+ this.getEmail());
        System.out.println("Phone Number : "+ this.getPhoneNum());
        System.out.println("Admin Name : "+ this.getAdminName());
        System.out.println("Gender : "+ this.getGender());
        System.out.println("Address : "+ this.getAlamat());
        System.out.println("TTL : "+ this.getTtl());
    }
}
