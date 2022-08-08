package vn.codegym.customer_management.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import vn.codegym.customer_management.model.Province;

public interface IProvinceRepository extends PagingAndSortingRepository<Province, Long> {

}
