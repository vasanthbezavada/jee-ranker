package org.vasanth.jeeranker.dto;

import java.util.List;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class SearchRequest {
  private List<SearchFilter> filters;
}
