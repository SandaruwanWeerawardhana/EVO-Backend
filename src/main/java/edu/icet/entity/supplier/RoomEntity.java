package edu.icet.entity.supplier;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;

    @OneToOne
    @JoinColumn(name = "property_id")
    private PropertyEntity property;

    @Column(nullable = false)
    private Integer beds;
}
