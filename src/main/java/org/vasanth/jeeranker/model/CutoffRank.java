package org.vasanth.jeeranker.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "CUTOFF_RANK")
public class CutoffRank {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID", nullable = false)
  private Integer id;

  @Column(name = "INSTITUTE", length = 225)
  private String institute;

  @Column(name = "PROGRAM", length = 225)
  private String program;

  @Column(name = "QUOTA", length = 225)
  private String quota;

  @Column(name = "SEAT_TYPE", length = 225)
  private String seatType;

  @Column(name = "GENDER", length = 225)
  private String gender;

  @Column(name = "OPENING_RANK", length = 225)
  private Integer openingRank;

  @Column(name = "CLOSING_RANK", length = 225)
  private Integer closingRank;

  @Column(name = "ACADEMIC_YEAR")
  private Integer academicYear;

  @Column(name = "ROUND")
  private Integer round;

  @Column(name = "TYPE", length = 225)
  private String type;

  @Column(name = "IS_PREPARATORY")
  private Boolean isPreparatory;
}
