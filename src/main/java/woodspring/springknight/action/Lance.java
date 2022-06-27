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
	
	private String domeUri = "http://localhost:9090/dome?num={num}";
	private RestTemplate restTemplate = new RestTemplate();
	private int number = 200;
	private int numString = 900;
	public List<FlyData> strike(String numStr) {
		Map<String, String> params = new HashMap<>(1);
	    params.put("num", Integer.valueOf( number).toString());
	    FlyData[] retObj = null;
	    try {
	    	retObj =  restTemplate.getForObject(domeUri, FlyData[].class, numStr);
	    } catch ( Exception ex) {
	    	logger.info( "Exception:"+ ex.getMessage());
	    	return null;
	    }
		//logger.info("uri:{}, params:{} response zise:{}", domeUri, params, retObj.length);
		//FlyDataList retObj =  restTemplate.getForObject(domeUri, FlyDataList.class, params);
		return Arrays.asList( retObj);
		
	}

}
