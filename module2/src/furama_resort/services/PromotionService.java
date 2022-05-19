package furama_resort.services;

import furama_resort.models.Booking;
import furama_resort.models.Customer;

import java.util.List;
import java.util.Map;

public interface PromotionService {
    List<Booking> getCustomerUseService(int year);
    Map<Customer, Integer> getCustomerVoucher(int amountOf10, int amountOf20, int amountOf50);
}
