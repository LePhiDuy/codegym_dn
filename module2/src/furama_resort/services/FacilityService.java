package furama_resort.services;

import furama_resort.models.Facility;
import furama_resort.models.House;
import furama_resort.models.Room;
import furama_resort.models.Villa;

import java.util.Map;

public interface FacilityService {
    void addVilla(Villa villa);
    void addHouse(House house);
    void addRoom(Room room);
    void add(Facility f);
    Map<Facility, Integer> getFacilitys();
    Facility getById(int id);
}
