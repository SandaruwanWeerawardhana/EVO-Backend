package edu.icet.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class ProfilePreviousWork {

    private Long workId;
    private Long  profileId;

    @NotEmpty(message = "Title not be empty")
    private String title;

    private String description;

    @PastOrPresent(message = "Completion date cannot be in the future")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate completionDate;

    private String imageUrls;
    private String clientName;
}
