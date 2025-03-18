package edu.icet.entity;

import edu.icet.util.UserType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
@Table(name = "User")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @NotEmpty(message = "First Name should not be blank")
    private String firstName;
    @NotEmpty(message = "Last Name should not be blank")
    private String lastName;
    @NotNull
    private String password;
    @Email(message = "Email should be valid")
    private String email;
    @PastOrPresent(message = "Registered date should be in past or present")
    private String registeredDate;
    @NotEmpty(message = "User type should not be blank")
    @Enumerated(EnumType.STRING)
    private UserType userType;
    @NotEmpty(message = "Contact Number should not be blank")
    private String contactNumber;
    @NotEmpty(message = "Address should not be blank")
    private String address;
    @NotEmpty(message = "City should not be blank")
    private String city;
}
