package edu.icet.dto.system;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Review {
   private Integer id;
   private String review;
   private String reviewer;
   private Long eventId;
}
