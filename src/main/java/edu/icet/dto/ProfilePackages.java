package edu.icet.dto;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProfilePackages {
    @NotNull
    @Min(1)
    private Long packageId;

    @NotNull
    @Min(1)
    private Long profileId;

    @NotNull
    @Size(min =1,max = 30)
    private boolean isActive;

    @NotNull
    @Size(min = 1,max = 500)
    private String packageName;

    @NotNull
   @DecimalMax("10.0")@DecimalMin("0.0")
    private Double price;

}
