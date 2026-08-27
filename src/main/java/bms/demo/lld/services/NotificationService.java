package bms.demo.lld.services;

import bms.demo.lld.models.Booking;
import bms.demo.lld.models.User1;
import bms.demo.lld.observer.IObserver;

import java.util.ArrayList;
import java.util.List;

public class NotificationService {
    List<IObserver> observers;
    public NotificationService(){
        observers=new ArrayList<>();
    }

    public void addObserver(IObserver o){
        observers.add(o);
    }

    public void notifyAllObserevre(Booking b, User1 user1){
        for(int i=0;i<observers.size();i++){
            IObserver o=observers.get(i);
            o.onBookingConfirmed(b,user1);
        }
    }

}
