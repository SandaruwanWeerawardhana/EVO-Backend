package edu.icet.dto.supplier;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProfilePreviousWorkImage {
    @NotNull
    @Size(min = 1, max = 15)
    private Long profilePreviousWorkImageId;

    @NotNull
    private Long profilePreviousWorkId;

    @NotBlank
    private String imageUrl;
}
