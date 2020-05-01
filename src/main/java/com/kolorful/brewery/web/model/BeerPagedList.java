package com.kolorful.brewery.web.model;

import java.util.List;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public class BeerPagedList extends PageImpl<BeerDto> {
	
	 static final long serialVersionUID = 1114715135625836949L;

	public BeerPagedList(List<BeerDto> content, Pageable pageable, long total) {
		super(content, pageable, total);	
	}
	
	public BeerPagedList(List<BeerDto> content) {
        super(content);
    }

	
}
