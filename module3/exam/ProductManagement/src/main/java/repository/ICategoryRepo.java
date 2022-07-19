package repository;

import model.Category;

import java.util.List;

public interface ICategoryRepo {
    List<Category> getAll();
}
