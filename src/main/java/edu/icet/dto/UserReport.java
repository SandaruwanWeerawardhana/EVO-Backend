package edu.icet.dto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserReport {

    @NotNull
    @NotEmpty(message = "ID should not be blank")
    private Long userId;
    @NotNull
    @NotEmpty
    private Long reportId;
}
