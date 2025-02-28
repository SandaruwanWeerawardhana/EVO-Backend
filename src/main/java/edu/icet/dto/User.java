package edu.icet.dto;



import edu.icet.utill.UserType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    @NotEmpty(message = "User ID should not be blank")
    private Integer userId;
    @NotEmpty(message = "User name should not be blank")
    private String userName;
    private String password;
    @Email(message = "Email should be valid")
    private String email;
    @PastOrPresent(message = "Registered date should be in past or present")
    private String registeredDate;
    @NotEmpty(message = "User type should not be blank")
    private UserType userType;


}
