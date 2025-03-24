package edu.icet.dto.supplier;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProfilePreviousWork {

    private Long previousWorkID;
    private Long  profileID;
    private Long  customerID;
    @NotBlank(message = "Title not be empty")
    private String title;
    @NotBlank(message = "Description not be empty")
    private String description;
    @PastOrPresent(message = "Completion date cannot be in the future")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate completionDate;
}
