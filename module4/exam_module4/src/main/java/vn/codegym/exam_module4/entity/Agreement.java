package vn.codegym.exam_module4.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Agreement {
    @Id
    private String id;
    private String personName;
    private String cmnd;
    private LocalDate date;
    private Long time;
    private Double totalPrice;
    @OneToOne
    @JoinColumn(name = "hostel_id")
    private Hostel hostel;
}
