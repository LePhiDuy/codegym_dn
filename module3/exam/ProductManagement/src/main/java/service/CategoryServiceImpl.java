package service;

import model.Category;
import repository.CategoryRepoImpl;
import repository.ICategoryRepo;

import java.util.List;

public class CategoryServiceImpl implements ICategoryService{
    private ICategoryRepo categoryRepo = new CategoryRepoImpl();
    @Override
    public List<Category> getAll() {
        return categoryRepo.getAll();
    }
}
