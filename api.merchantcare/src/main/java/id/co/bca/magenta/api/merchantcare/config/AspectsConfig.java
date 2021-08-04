package id.co.bca.magenta.api.merchantcare.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import id.co.bca.magenta.api.merchantcare.monitor.MonitorFactory;
import id.co.bca.magenta.api.merchantcare.monitor.jamon.JamonMonitorFactory;

//  1. Add a class-level annotation to scan for components
//	located in the rewards.internal.aspects package.
//	2. Add another class-level annotation to instruct Spring 
//	to process beans that have the @Aspect annotation.
@Configuration
@ComponentScan("id.co.bca.magenta.api.merchantcare.aspect") // 1
@EnableAspectJAutoProxy(proxyTargetClass=true) // 2
public class AspectsConfig {

	@Bean
	public MonitorFactory monitorFactory() {
		return new JamonMonitorFactory();
	}

}
