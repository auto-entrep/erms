package com.erms.app.entity;
import java.time.LocalDate;
import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@NoArgsConstructor  @AllArgsConstructor @Getter @Setter @ToString @Builder
@Table
@Entity
public class Employee {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
 //   private String employeeId;
   private Long employeeId;
    private String fullName;
    private String jobTitle;
    private String department;
   // private Date hireDate;
    private LocalDate hireDate;
    private String employmentStatus;
    private String contactInfo;
    private String address;
    private String role;

}
