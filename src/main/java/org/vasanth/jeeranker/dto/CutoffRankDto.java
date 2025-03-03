package org.vasanth.jeeranker.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CutoffRankDto {
  private String institute;
  private String program;
  private String quota;
  private String seatType;
  private String gender;
  private Integer openingRank;
  private Integer closingRank;
  private Integer academicYear;
  private Integer round;
  private String type;
  private Boolean isPreparatory;
}
