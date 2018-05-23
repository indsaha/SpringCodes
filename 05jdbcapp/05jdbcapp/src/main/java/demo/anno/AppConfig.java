package demo.anno;
import demo.beans.*;
import demo.repo.WalletRepoImple;
import demo.service.WalletServiceImple;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
//@ComponentScan(basePackages="demo")
public class AppConfig {
	
@Bean( value="map")
public Map<String,Customer> getMap(){
	return new HashMap<String,Customer>();
	
}

//@Bean(value ="repo")
//public WalletRepoImple getRepo() {
//	
//	return new WalletRepoImple(getMap());
//}
@Bean(value="service")

public WalletServiceImple getService()
{
	//Map m = null ; 
	//((AppConfig) m).getMap();
	//map.getMap();
	return new WalletServiceImple(getRepo());
}

@Bean(name ="repo")
public WalletRepoImple getRepo() {
	
	return new WalletRepoImple();
}
}
