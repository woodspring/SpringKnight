package woodspring.springknight.action;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import woodspring.springknight.config.MaceFeignClientConfig;
import woodspring.springknight.model.FlyData;


@FeignClient(name="maceFeignClient", url="${client.dome.baseUrl}", 
			configuration = MaceFeignClientConfig.class,
			fallback = MaceFeignFallback.class)  
public interface MaceFeignClient {
	@RequestMapping(method = RequestMethod.GET, value = "/action", produces="application/json")
	public List<FlyData> doAction() ;
	
	@RequestMapping(method = RequestMethod.GET, value = "/action/{times}", produces="application/json")
	public List<FlyData> doActionTimes( @PathVariable("times") int times) ;
	
	@RequestMapping(method = RequestMethod.GET, value = "/actionTime/{ind}", produces="application/json")
	public String doSimpleActionTime( @PathVariable("ind") int ind) ;
	
	@RequestMapping(method = RequestMethod.GET, value = "/actionTime/pId/{pId}/ind/{ind}", produces="application/json")
	public String doSimpleActionTime(@PathVariable("pId") int pId,  @PathVariable("ind") int ind) ;
}
