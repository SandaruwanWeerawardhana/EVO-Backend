package edu.icet.dto.event;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BirthdayParty {
    private Long id;

    @NotNull(message = "OwnerName cannot be null")
    private String ownerName;
}
