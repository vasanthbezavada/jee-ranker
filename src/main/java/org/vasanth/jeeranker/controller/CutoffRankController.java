package org.vasanth.jeeranker.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.vasanth.jeeranker.dto.CutoffRankDto;
import org.vasanth.jeeranker.dto.SearchRequest;
import org.vasanth.jeeranker.service.CutoffRankService;

@RestController
@RequestMapping("/cutoffs")
public class CutoffRankController {

  public static Logger log = LoggerFactory.getLogger(CutoffRankController.class);

  private final CutoffRankService cutoffRankService;

  public CutoffRankController(CutoffRankService cutoffRankService) {
    this.cutoffRankService = cutoffRankService;
  }

  @GetMapping("/getDataSet")
  public ResponseEntity<List<CutoffRankDto>> getDataSet() {
    return ResponseEntity.ok(cutoffRankService.getCutoffRanks());
  }

  @PostMapping("/search")
  @Operation(
      summary = "Search records with filters",
      description = "Applies multiple filters to search records based on specified conditions.",
      requestBody =
          @io.swagger.v3.oas.annotations.parameters.RequestBody(
              description = "List of search filters",
              required = true,
              content =
                  @Content(
                      mediaType = "application/json",
                      examples = {
                        @ExampleObject(
                            name = "Search by Program",
                            description = "Filter records where program is 'Computer Science'",
                            value =
                                "{ \"filters\": [ { \"searchKey\": \"program\", \"value\": \"Computer Science\", \"operator\": \"EQUAL\" } ] }"),
                        @ExampleObject(
                            name = "Search by Rank Range",
                            description = "Find records where closing rank is less than 1000",
                            value =
                                "{ \"filters\": [ { \"searchKey\": \"closingRank\", \"value\": \"1000\", \"operator\": \"LESS_THAN\" } ] }"),
                        @ExampleObject(
                            name = "Multiple Filters",
                            description = "Filter by program and closing rank together",
                            value =
                                "{ \"filters\": [ { \"searchKey\": \"program\", \"value\": \"Mechanical Engineering\", \"operator\": \"EQUAL\" }, { \"searchKey\": \"closingRank\", \"value\": \"500\", \"operator\": \"GREATER_THAN\" } ] }")
                      })),
      responses = {
        @ApiResponse(responseCode = "200", description = "Search executed successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid input")
      })
  public ResponseEntity<List<CutoffRankDto>> searchCutOffRank(
      @RequestBody SearchRequest searchReq) {
    log.info(searchReq.toString());
    return ResponseEntity.ok(cutoffRankService.searchRankList(searchReq.getFilters()));
  }
}
