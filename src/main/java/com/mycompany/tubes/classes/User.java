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
    public String requestForm;

    public User(String userId, String email, String phone, String name, boolean gender, String ttl, String alamat, String instanceId, String photo, String requestForm) {
        this.userId = userId;
        this.email = email;
        this.phone = phone;
        this.name = name;
        this.gender = gender;
        this.ttl = ttl;
        this.alamat = alamat;
        this.instanceId = instanceId;
        this.photo = photo;
        this.requestForm = requestForm;
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

//    tambahin input dan ngirim ke admin
    public void setRequestForm(String requestForm) {
        this.requestForm = requestForm;
    }

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

    public boolean isGender() {
        return gender;
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
    
//  unchecked!!!
//  can be an abstract method to init/call in checkIn() method
    public int editDistance(String s1, String s2) {
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        
        int[] cost = new int[s2.length()+1];
        for (int i = 0; i <= s1.length(); i++) {
            int lastValue = i;
            for (int j = 0; i <= s2.length(); j++) {
                if (i==0) {
                    cost[j] = j;
                } else {
                    if (j > 0) {
                        int newValue = cost[j-1];
                        if (s1.charAt(i-1) != s2.charAt(j-1)) {
                            newValue = Math.min(Math.min(newValue, lastValue), cost[j]) + 1;
                            cost[j-1] = lastValue;
                            lastValue = newValue;
                        }
                    }
                }
            }
            if (i > 0) {
                cost[s2.length()] = lastValue;
            }
        }
        return cost[s2.length()];
    }
    
//  unchecked!!!
    public boolean checkIn(String photo, String newPhoto) {
        
        
        
        String longer = photo, shorter = newPhoto;
        if (longer.length() < shorter.length()) {
            longer = newPhoto;
            shorter = photo;
        }
        
        int longerLength = longer.length();
        double accuracy = 0.0;
        if (longerLength == 0) {
            accuracy = 1.0;
        } else {
            accuracy = (longerLength - editDistance(longer, shorter)) / (double)longerLength;
        }
        
        if (accuracy > 0.7) {
            return true;
        }
                
        return false;
    }
    
//  send request to admin
    public String requestCheckIn(boolean checkInStatus) {
        if (checkInStatus) {
            
        }
        return "N/A";
    }
    
    public void checkOut() {
        System.out.println("Program akan keluar...");
        System.exit(0);
    }
    
}
