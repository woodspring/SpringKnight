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
	public List<FlyData> work(@RequestParam(value="action", required = false, defaultValue="100") String action) {
		return knight.action( Integer.valueOf(action));
		
	}

}
