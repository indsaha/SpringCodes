package demo.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import demo.bean.Customer;
import demo.repo.WalletRepoImpl;
import demo.service.WalletServiceImpl;

@Configuration
@Component
public class AppConfig {
	@Bean(name="map")
	public Map<String, Customer> getMap()
	{
		return new HashMap<String, Customer>();
		
	}
	
	@Bean(name="repo")
	public WalletRepoImpl repoService()
	{
		return new demo.repo.WalletRepoImpl(getMap()) ;
		
	}
	
	@Bean(name="service")
	public demo.service.WalletServiceImpl walletService()
	{
		return new demo.service.WalletServiceImpl(repoService());
		
	}
	
	

}
