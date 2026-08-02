package com.lld.hotel_management.services;

import com.lld.hotel_management.models.persons.Admin;
import com.lld.hotel_management.models.persons.Guest;
import com.lld.hotel_management.models.persons.Receipnist;
import lombok.Getter;

import java.util.List;

@Getter
public class UserService {
    List<Guest> guests;
    List<Admin> admins;
    List<Receipnist> receipnists;

    public UserService( List<Guest> guests,List<Admin> admins,List<Receipnist> receipnists){
        this.guests=guests;
        this.admins=admins;
        this.receipnists=receipnists;
    }


}
