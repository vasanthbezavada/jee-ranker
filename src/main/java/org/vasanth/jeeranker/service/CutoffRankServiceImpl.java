package org.vasanth.jeeranker.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.vasanth.jeeranker.dto.CutoffRankDto;
import org.vasanth.jeeranker.dto.SearchFilter;
import org.vasanth.jeeranker.mapper.CutoffRankMapper;
import org.vasanth.jeeranker.model.CutoffRank;
import org.vasanth.jeeranker.repository.CutoffRankRepo;
import org.vasanth.jeeranker.repository.CutoffRankSpecification;

@Service
public class CutoffRankServiceImpl implements CutoffRankService {

  final CutoffRankRepo cutoffRankRepo;

  public CutoffRankServiceImpl(CutoffRankRepo cutoffRankRepo) {
    this.cutoffRankRepo = cutoffRankRepo;
  }

  public List<CutoffRankDto> getCutoffRanks() {
    List<CutoffRank> allRanks = cutoffRankRepo.findAll();
    return allRanks.stream().map(CutoffRankMapper.INSTANCE::toDto).toList();
  }

  public List<CutoffRankDto> searchRankList(List<SearchFilter> filters) {
    CutoffRankSpecification spec = new CutoffRankSpecification(filters);
    List<CutoffRank> filteredList = cutoffRankRepo.findAll(spec);
    return filteredList.stream().map(CutoffRankMapper.INSTANCE::toDto).toList();
  }
}
