package org.spring.in.action.web.tutorial.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.spring.in.action.web.tutorial.entity.Spittle;
import org.springframework.stereotype.Repository;

@Repository
public class SpittleRepositoryImp implements SpittleRepository {

	@Override
	public List<Spittle> findSpittles(long max, int count) {
		List<Spittle> spittles = generateSpittles(max,count);
		System.out.println(">>> SpittleRepositoryImp: findSpittles, spittles="+spittles+"<<<");
		return spittles;
	}
	
	private List<Spittle> generateSpittles(long max,int count){
		List<Spittle> spittles = new ArrayList<>();
		Random random = new Random();
		for(int i=0;i<count;i++){
			if(i == max)break;
			spittles.add(new Spittle("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. "+i,
									new Date(), 0.0,0.0));
		}	
		return spittles;
	}
	
}
