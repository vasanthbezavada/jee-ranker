package org.vasanth.jeeranker.controller;

public class WebConstants {
  public static final String EXAMPLE_1 = "Search by academicYear,round,seatType,closingRank & gender";
  public static final String EXAMPLE_1_DESCRIPTION =
      "SEARCH 2024 OPEN-CAT-GENERAL CLOSING RANK LESS THAN 1000";
  public static final String EXAMPLE_1_VALUE =
      """
        {
          "filters": [
            {
              "searchKey": "academicYear",
              "value": 2024,
              "operator": "EQUAL"
            },
            {
              "searchKey": "round",
              "value": 5,
              "operator": "EQUAL"
            },
            {
              "searchKey": "seatType",
              "value": "OPEN",
              "operator": "EQUAL"
            },
            {
              "searchKey": "closingRank",
              "value": 1000,
              "operator": "LESS_THAN"
            },{
              "searchKey": "gender",
              "value": "Gender-Neutral",
              "operator": "EQUAL"
            }
          ]
        }
        """;
}
