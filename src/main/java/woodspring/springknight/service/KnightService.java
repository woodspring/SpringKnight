package woodspring.springknight.service;

import java.util.List;

import woodspring.springknight.model.FlyData;

public interface KnightService {
	
	List<FlyData> action(int actionTimes );
	List<String> actionLoop(int times, int action );
	List<String> swingMace(int times );

}
