package org.vasanth.jeeranker.service;

import org.springframework.stereotype.Service;
import org.vasanth.jeeranker.dto.CutoffRankDto;
import org.vasanth.jeeranker.dto.SearchFilter;

import java.util.List;

public interface CutoffRankService {
  List<CutoffRankDto> getCutoffRanks();
  List<CutoffRankDto> searchRankList(List<SearchFilter> filters);
}
