package vn.codegym.product_demo_md4.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.product_demo_md4.entity.Product;
import vn.codegym.product_demo_md4.repository.IProductRepository;
import vn.codegym.product_demo_md4.service.IProductService;
import vn.codegym.product_demo_md4.util.CommonUtil;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Page<Product> find(String searchBy, String keyword, Pageable pageable) {
        switch (searchBy) {
            case "name":
                return productRepository.findAllByNameContaining(keyword, pageable);
            case "price":
                return productRepository.findByPriceGreaterThanEqual(CommonUtil.parseDouble(keyword), pageable);
            case "manufacturer":
                return productRepository.findByManufacturerContaining(keyword, pageable);
            default:
                return productRepository.findAllByValue("%" + keyword  + "%", pageable);
        }
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

}
