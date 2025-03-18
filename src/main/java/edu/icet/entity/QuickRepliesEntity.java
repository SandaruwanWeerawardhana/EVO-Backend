
package edu.icet.entity;

import edu.icet.util.CategoryType;
import jakarta.persistence.*;
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
    @Enumerated(EnumType.STRING)
    private CategoryType category;


}
