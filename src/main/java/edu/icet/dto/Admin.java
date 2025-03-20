package edu.icet.dto;
import edu.icet.util.AdminType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Admin {
    @NotNull
    private Long adminId;
    @NotNull
    private AdminType type;
}
