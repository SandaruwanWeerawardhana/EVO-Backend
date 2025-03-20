package edu.icet.dto;


import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatImage {
    @NotEmpty
   private Long id;
    @NotEmpty
   private String imagePath;
}
