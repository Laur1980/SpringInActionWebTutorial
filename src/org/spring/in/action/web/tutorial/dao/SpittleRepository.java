package org.spring.in.action.web.tutorial.dao;

import java.util.List;

import org.spring.in.action.web.tutorial.entity.Spittle;

public interface SpittleRepository {
	
	List<Spittle> findSpittles(long max, int count);
}
