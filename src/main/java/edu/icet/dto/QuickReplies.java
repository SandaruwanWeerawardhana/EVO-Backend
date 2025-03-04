
package edu.icet.dto;

import edu.icet.util.Category;
import jakarta.validation.constraints.*;
        import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class QuickReplies {

    @NotNull
    @Positive
    private Long replyID;

    @NotNull
    @Positive
    private Long supplierID;

    @NotNull
    @Size(min = 5 , max = 225)
    private String content;

    @NotNull
    private Category category;


}
