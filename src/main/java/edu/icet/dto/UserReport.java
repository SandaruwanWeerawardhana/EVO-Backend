package edu.icet.dto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.usertype.UserType;
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserReport {
    @NotNull
    private Long id;
    @NotNull
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;
    @NotNull
    private UserType usertype;
    @NotNull
    private String permission;
}
