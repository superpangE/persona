package com.ssafy.persona.domain.search.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class SearchCloud {
	@Id
	private int cloudSeq;
	@Column
	private String searchWord;
	@Column
	private int searchWeight;
	@Column
	private String searchDate;
}
