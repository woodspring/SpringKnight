package woodspring.springknight.model;

import java.util.ArrayList;
import java.util.List;

public class FlyDataList {
	private List<FlyData> flyDataList;
	
	public FlyDataList() {
		flyDataList = new ArrayList<FlyData>();
	}

	public List<FlyData> getFlyDataList() {
		return flyDataList;
	}

	public void setFlyDataList(List<FlyData> flyDataList) {
		this.flyDataList = flyDataList;
	}
	
}
