package edu.icet.dto.system;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Terms {

    @NotNull
    private Long termId;

    @NotNull
    private Long profileId;

    @NotBlank
    @Size(min = 100)
    private String content;

    @NotNull
    private Boolean isActive;

    @NotNull
    private LocalDateTime lastUpdated;
}
