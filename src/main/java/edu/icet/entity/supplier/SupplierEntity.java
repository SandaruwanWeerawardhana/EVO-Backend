package edu.icet.entity.supplier;

import edu.icet.entity.event.EventEntity;
import edu.icet.entity.system.TermsEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Suppliers")
public class SupplierEntity {
    @Id
    private long userId;

    @OneToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @OneToOne
    @JoinColumn(name = "terms_id")
    private TermsEntity terms;

    private String businessName;

    private String email;

    private String phoneNumber;
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "locationId",referencedColumnName = "locationId")
    private LocationEntity location;

    private String profilePictureImageUrl;

    private Boolean availability;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private EventEntity event;
}
