package woodspring.springknight.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import woodspring.springknight.action.Lance;
import woodspring.springknight.model.FlyData;
import woodspring.springknight.service.KnightService;


@Service
public class KnightServiceImpl implements KnightService {
	
	@Autowired
	Lance lance;

	@Override
	public List<FlyData> action(int actionTimes) {
		// TODO Auto-generated method stub
		List<FlyData> ret = lance.strike();
		return ret;
	}

}
