package vn.codegym.exam_module4.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import vn.codegym.exam_module4.entity.Hostel;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AgreementDto {
    @Pattern(regexp = "^HD-[0-9]{4}$", message = "Mã hợp đồng có dạng HD-XXXX, X từ 0 đến 9")
    private String id;
    private String personName;
    @NotBlank(message = "CMND không được để trống")
    private String cmnd;
    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;
    private Long time;
    private Double totalPrice;
    private Hostel hostel;
}
