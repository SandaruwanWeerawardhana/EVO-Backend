package edu.icet.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Report {
    @NotNull
    private Long reportId;
    @Size(min = 5,max = 30)
    private String title;
    private String description;
    @PastOrPresent
    private String dateCreate;
    @PastOrPresent
    private String dateModify;
    private String category;

}
