package woodspring.springknight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import woodspring.springknight.model.FlyData;
import woodspring.springknight.service.KnightService;

@RestController
public class KnightsController {
	
	@Autowired
	KnightService knight;
	
	@GetMapping("/work")
	public List<String> work(@RequestParam(value="times", required = true, defaultValue="50") String times,
			@RequestParam(value="action", required = false, defaultValue="1000") String action) {
		return knight.actionLoop(Integer.valueOf(times),  Integer.valueOf(action));
		
	}
	
	@GetMapping("/mace")
	public String swingMace(@RequestParam(value="times", required = true, defaultValue="50") String times,
			@RequestParam(value="action", required = false, defaultValue="1000") String action) {
		return knight.swingMace( 119);
		
	}

}
