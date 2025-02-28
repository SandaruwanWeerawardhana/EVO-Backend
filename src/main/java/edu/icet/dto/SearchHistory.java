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
public class SearchHistory {
    @NotNull
    private Long searchId;
    @PastOrPresent
    private String date;
    @PastOrPresent
    private String time;
    private String searchType;
    @Size(min = 3,max = 30)
    private String description;
}
