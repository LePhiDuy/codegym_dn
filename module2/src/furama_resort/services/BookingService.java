package furama_resort.services;

import furama_resort.models.Booking;

import java.util.Stack;
import java.util.TreeSet;

public interface BookingService {
    TreeSet<Booking> getAll();
    void save(Booking booking);
    Stack<Booking> getForContract();
}
