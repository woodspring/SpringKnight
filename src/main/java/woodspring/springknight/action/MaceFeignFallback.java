package woodspring.springknight.action;

import java.util.List;

import org.springframework.stereotype.Component;

import woodspring.springknight.model.FlyData;


@Component
public class MaceFeignFallback implements MaceFeignClient {

	@Override
	public List<FlyData> doAction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FlyData> doActionTimes(int times) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String doSimpleActionTime(int ind) {
		// TODO Auto-generated method stub
		return new String("ind "+ ind+" fallback Response");
	}

	@Override
	public String doSimpleActionTime(int pId, int ind) {
		// TODO Auto-generated method stub
		return new String("Dome: doSimpleActionTime,  pId:"+ pId+ " times:"+ ind+" fallback Response");
	}


}
