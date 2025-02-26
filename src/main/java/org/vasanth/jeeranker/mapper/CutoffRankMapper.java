package org.vasanth.jeeranker.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.vasanth.jeeranker.dto.CutoffRankDto;
import org.vasanth.jeeranker.model.CutoffRank;

@Mapper
public interface CutoffRankMapper {

    CutoffRankMapper INSTANCE = Mappers.getMapper(CutoffRankMapper.class);

    CutoffRankDto toDto(CutoffRank cutoffRank);
}
