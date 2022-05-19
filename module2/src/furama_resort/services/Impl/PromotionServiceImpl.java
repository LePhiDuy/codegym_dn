package furama_resort.services.Impl;

import furama_resort.models.Booking;
import furama_resort.models.Customer;
import furama_resort.services.PromotionService;

import java.util.List;
import java.util.Map;

public class PromotionServiceImpl implements PromotionService {
    @Override
    public List<Booking> getCustomerUseService(int year) {
        return null;
    }

    @Override
    public Map<Customer, Integer> getCustomerVoucher(int amountOf10, int amountOf20, int amountOf50) {
        return null;
    }
}
