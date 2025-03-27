package edu.icet.entity.supplier;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "bookingSlot")
public class BookingSlotEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingSlotId;

    @ManyToOne
    @JoinColumn(name = "property_id")
    private PropertyEntity property;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
