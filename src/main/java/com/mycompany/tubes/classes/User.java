/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tubes.classes;

import java.util.*;
import java.lang.*;

/**
 *
 * @author lenovo
 */
public class User {
    public String userId;
    public String email;
    public String phone;
    public String name;
    public boolean gender;
    public String ttl;
    public String alamat;
    protected String instanceId;
    public String photo;
    public String newPhoto;
//    public boolean requestForm;

    public User(String userId, String email, String phone, String name, boolean gender, String ttl, String alamat, String instanceId, String photo) {
        this.userId = userId;
        this.email = email;
        this.phone = phone;
        this.name = name;
        this.gender = gender;
        this.ttl = ttl;
        this.alamat = alamat;
        this.instanceId = instanceId;
        this.photo = photo;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    
    public void setNewPhoto(String newPhoto) {
        this.newPhoto = newPhoto;
    }

//  tambahin input dan ngirim ke admin
//    public void setRequestForm(String newPhoto) {
//        if (!checkIn(this.photo, newPhoto)) {
//            this.requestForm = true;
//        } else {
//            this.requestForm = false;
//        }
//    }

    public String getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        if (gender) {
            return "Laki-laki";
        }
        return "Perempuan";
    }

    public String getTtl() {
        return ttl;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public String getPhoto() {
        return photo;
    }
    
    public String getNewPhoto() {
        return newPhoto;
    }
    
//    public boolean getRequestForm() {
//        return requestForm;
//    }
    
//  unchecked!!!
    public boolean checkIn() {
        String xPhoto = photo.toLowerCase();
        String xNewPhoto = newPhoto.toLowerCase();
        
        double correct = 0;
        if (xPhoto.length() == xNewPhoto.length()) {
            for (int i = 0; i < xPhoto.length(); i++) {
                if (xPhoto.charAt(i) == xNewPhoto.charAt(i)){
                    correct++;
                }
            }
        } else {
            return false;
        }
        
        return (correct/Double.valueOf(xPhoto.length())) > 0.6;
    }
    
//  send request to admin
//  should be in admin(?)
//    public String requestCheckIn(boolean checkInStatus) {
//        if (!checkInStatus) {
//            
//        }
//        return "N/A";
//    }
    
//    public void checkOut() {
//        
//    }
    
    public void displayInfo() {
        System.out.println("==== Profil User ====");
        System.out.println("Nama\t: " + getName());
        System.out.println("Email\t: " + getEmail());
        System.out.println("No.Telp\t: " + getPhone());
        System.out.println("Gender\t: " + getGender());
        System.out.println("TTL\t: " + getTtl());
        System.out.println("Alamat\t: " + getAlamat());
        System.out.println("Foto profil\t: " + getPhoto());
    }
    
}
