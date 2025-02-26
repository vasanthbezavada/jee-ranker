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
  private String openingRank;
  private String closingRank;
  private Integer academicYear;
  private Integer round;
  private String type;
}
