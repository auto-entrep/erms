package com.erms.app.entity;
import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;


@NoArgsConstructor  @AllArgsConstructor @Builder @Getter @Setter @ToString
@Entity
public class Employee {

	@Id
    private String employeeId;
    private String fullName;
    private String jobTitle;
    private String department;
    private Date hireDate;
    private String employmentStatus;
    private String contactInfo;
    private String address;
    private String role;

}
