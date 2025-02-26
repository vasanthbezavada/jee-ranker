package org.vasanth.jeeranker.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.vasanth.jeeranker.model.CutoffRank;

@Repository
public interface CutoffRankRepo
    extends JpaRepository<CutoffRank, Integer>, JpaSpecificationExecutor<CutoffRank> {

  List<CutoffRank> findCutoffRankByAcademicYearAndQuota(Integer academicYear, String quota);
}
