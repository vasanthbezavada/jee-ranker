package org.vasanth.jeeranker.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class SearchFilter {

    private String searchKey;
    private Object value;
    private SearchOperator operator;

}
