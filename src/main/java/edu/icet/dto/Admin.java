package edu.icet.dto;
import edu.icet.utill.AdminType;
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
    private Integer AdminID;
    @NotNull
    private AdminType Type;
}
