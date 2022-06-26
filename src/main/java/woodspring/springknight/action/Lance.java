package woodspring.springknight.action;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import woodspring.springknight.model.FlyData;
import woodspring.springknight.model.FlyDataList;

@Component
public class Lance {
	private final static Logger logger = LoggerFactory.getLogger(Lance.class);
	
	private String domeUri = "http://localhost:9090/dome";
	private RestTemplate restTemplate = new RestTemplate();
	
	public List<FlyData> strike() {
		Map<String, Object> params = new HashMap<>(2);
	    params.put("num", "200");
		FlyData[] retObj =  restTemplate.getForObject(domeUri, FlyData[].class, params);
		//FlyDataList retObj =  restTemplate.getForObject(domeUri, FlyDataList.class, params);
		return Arrays.asList( retObj);
		
	}

}
