package service;

import dao.CategoryDAO;
import model.Category;

import java.util.List;

public class CategoryService {
    private CategoryDAO categoryDAO = new CategoryDAO();
    public List<Category> getAll() {
        return categoryDAO.getAll();
    }
}
