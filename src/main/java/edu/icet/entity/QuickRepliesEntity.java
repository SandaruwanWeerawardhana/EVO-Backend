
package edu.icet.entity;

import edu.icet.util.Category;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "QuickReplies")
public class QuickRepliesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long replyID;

    @Column(nullable = false)
    private Long supplierID;

    private String content;

    @Column(nullable = false)
    private Category category;


}
