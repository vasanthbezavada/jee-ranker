package org.vasanth.jeeranker.controller;

import static org.vasanth.jeeranker.controller.WebConstants.*;

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
                            name = EXAMPLE_1,
                            description = EXAMPLE_1_DESCRIPTION,
                            value = EXAMPLE_1_VALUE)
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
