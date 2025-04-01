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
    private Long profilePreviousWorkImageId;

    @NotNull
    private ProfilePreviousWork profilePreviousWork;

    @NotBlank
    private String imageUrl;
}
