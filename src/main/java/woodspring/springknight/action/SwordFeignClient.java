package woodspring.springknight.action;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="swordFeignClient", url="http://192.168.0.107:8090/localhost:8090")  
public interface SwordFeignClient {

}
