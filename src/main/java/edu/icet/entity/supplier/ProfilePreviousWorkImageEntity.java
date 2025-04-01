package edu.icet.entity.supplier;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="profile_previous_work_images")
public class ProfilePreviousWorkImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profilePreviousWorkImageId;

    @Column(nullable = false)
    private String imageUrl;

}
