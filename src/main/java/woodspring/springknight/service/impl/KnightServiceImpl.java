package woodspring.springknight.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import woodspring.springknight.action.Lance;
import woodspring.springknight.action.MaceFeignClient;
import woodspring.springknight.model.FlyData;
import woodspring.springknight.service.KnightService;


@Service
@Qualifier("KnightServiceImplAction")
public class KnightServiceImpl implements KnightService {
	private final static Logger logger = LoggerFactory.getLogger(KnightServiceImpl.class );
	@Autowired
	Lance lance;
	
	@Autowired 
	MaceFeignClient maceFeignClient;

	@Override
	public List<String> actionLoop(int times, int action) {
		// TODO Auto-generated method stub
		StringBuffer strB = new StringBuffer();
		logger.info("START");
		var resultStr = IntStream.rangeClosed( 1,  times).mapToObj( item -> {
			List<FlyData> ret = action( action);
			if (ret == null) {
			strB.append("NULL");
			return strB.toString();
			}
			List<FlyData> sortedRet = ret.stream().sorted(flyDataComparator).collect( Collectors.toList());
			String retStr = String.format(" [ item:%d, processTime, min:%s on %d, max:%s on %d size:%d]",
					item, sortedRet.get(0).getpTime().toString(), sortedRet.get(0).getpId(),
					sortedRet.get( sortedRet.size()-1).getpTime().toString(), sortedRet.get( sortedRet.size()-1).getpId(),
					sortedRet.size());
			logger.info("[ item:{}, processTime, min:{} on {}, max{} on {}] size:{}]",
					item, sortedRet.get(0).getpTime(), sortedRet.get(0).getpId(),
					sortedRet.get( sortedRet.size()-1).getpTime(), sortedRet.get( sortedRet.size()-1).getpId(),
					sortedRet.size()+"   " + sortedRet.toString());
			strB.append(retStr);
			return retStr;
		}).collect(Collectors.toList());
		logger.info(strB.toString());
		return resultStr;
	}
	
	@Override
	public List<FlyData> action(int actionTimes) {
		// TODO Auto-generated method stub
		List<FlyData> ret = lance.strike(Integer.valueOf(actionTimes).toString());
		return ret;
	}
	
	
	Comparator<FlyData> flyDataComparator = new Comparator<FlyData>() {
		  @Override
		  public int compare(FlyData fd1, FlyData fd2) {
		    return fd2.getpTime().compareTo(fd1.getpTime());
		  }
		};

	@Override
	public List<String> swingMace(int times) {
		StringBuffer strBuf = new StringBuffer();
		List<CompletableFuture<String>> listOfRe =  IntStream.range(1, times)
														.mapToObj( pId -> CompletableFuture.supplyAsync(
																() -> maceFeignClient.doSimpleActionTime( pId, times) ))
				.collect( Collectors.toList());
		
		List<String> retStr = listOfRe.stream().map(CompletableFuture::join)
						.collect( Collectors.toList());

		return retStr;
	} 
	
	
	public String swingMaceOnce() {
		var Str = maceFeignClient.doSimpleActionTime(1);
		return Str;
	} 

}
