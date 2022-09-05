package vn.codegym.product_demo_md4.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import vn.codegym.product_demo_md4.entity.Category;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Long id;
    @NotEmpty(message = "Name cannot be empty")
    private String name;
    @Min(value = 500, message = "Price should be greater than 500")
    private double price;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate expDate;
    private String manufacturer;
    private Category category;
}
