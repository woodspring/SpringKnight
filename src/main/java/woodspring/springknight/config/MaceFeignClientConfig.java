package woodspring.springknight.config;


import org.springframework.boot.autoconfigure.sendgrid.SendGridProperties.Proxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Feign;
import feign.Logger;
import feign.RequestInterceptor;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.codec.ErrorDecoder;
import feign.codec.ErrorDecoder.Default;
import lombok.AllArgsConstructor;
import lombok.val;
import woodspring.springknight.action.MaceFeignClient;
import feign.codec.ErrorDecoder;
import feign.okhttp.OkHttpClient;


@Configuration
public class MaceFeignClientConfig {
	//private final Encoder encoder = new GsonEncoder();
   // private final Decoder decoder = new GsonDecoder();
	 /**
     * Enable this bean if you want to add headers in HTTP request
     */
    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("Content-Type", "application/json");
            requestTemplate.header("Accept", "application/json");
            requestTemplate.header("header_1", "value_1");
            requestTemplate.header("header_2", "value_2");
            requestTemplate.header("header_3", "value_3");
        };
    }
	 @Bean
	    public Logger.Level feignLoggerLevel() {
	        return Logger.Level.FULL;
	    }

	    @Bean
	    public ErrorDecoder errorDecoder() {
	        return new ErrorDecoder.Default();
	    }

//	    @Bean
//	    public OkHttpClient client() {
//	        return new OkHttpClient.Builder()
//	        		.proxy(new Proxy(Proxy.Type.HTTP,
//	        				new InetSocketAddress(proxyHost, proxyPort)))
//	        		.build();
//	    }
	
//	@Bean 
//	public MaceFeignClient maceFeignClient() {
//		return Feign.builder()
//				.requestInterceptor( interceptor -> {
//					interceptor.header("key", "value");
//				})
//				//.encoder( encoder)
//				//.decoder(decoder)
//				.errorDecoder((methodKey, response) -> {
//					ErrorDecoder defaultErrorEncoder = new Default();
//					return defaultErrorEncoder.decode(methodKey, response);
//				})
//				.target(MaceFeignClient.class, "http://192.168.0.107:9090/dome/action" );
//		
//	}

}
