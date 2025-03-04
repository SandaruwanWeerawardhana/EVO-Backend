package edu.icet.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profile {
    @NotNull(message = "ID cannot be null")
    @Min(value = 1, message = "ID must be a positive number")
    private Long id;

    @NotBlank(message = "Full name is required")
    @Size(min = 3, max = 50, message = "Full name must be between 3 and 50 characters")
    private String fullName;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Phone number is required")
    private String phoneNumber;

    @NotBlank(message = "Address is required")
    @Size(min = 10, max = 100, message = "Address must be between 10 and 100 characters")
    private String address;

    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 100, message = "Age cannot be more than 100")
    private Integer age;

    @NotBlank(message = "Gender is required")
    private String gender;
}