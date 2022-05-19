package furama_resort.services;

import java.util.List;

public interface Service<T> {
    void save(T t);
    List<T> getAll();
}
