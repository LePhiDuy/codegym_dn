package vn.codegym.exam_module4.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Hostel {
    @Id
    private String id;
    private Double s;
    private Double price;
    private boolean status;
    @OneToOne(mappedBy = "hostel")
    private Agreement agreement;
}
