package vn.easycredit.controller;

import java.util.concurrent.Executor;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;


/**
 * @author HienNT
 *
 */

@SpringBootApplication
@EnableEurekaClient
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableResourceServer
@EnableDiscoveryClient
@ComponentScan(value = "vn.easycredit")
@EnableAutoConfiguration
@EnableJpaRepositories(value = "vn.easycredit")
@EntityScan(basePackages = "vn.easycredit")
@EnableAsync
@EnableScheduling
public class EvnProjectApplication{
	

	
	@Autowired
	private Environment env;
	
	@Bean
	Queue queue() {
		return new Queue(env.getProperty("econtract-configurations.queue-log"), false);
	}
	
//	@Bean
//	Queue queue2() {
//		return new Queue(env.getProperty("queue-log-db"), false);
//	}
	
    @Bean(name = "asyncExecutor")
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(3);
        executor.setMaxPoolSize(3);
        executor.setQueueCapacity(100);
        executor.setThreadNamePrefix("AsynchThread-");
        executor.initialize();
        return executor;
    }
	
	public static void main(String[] args) {
		SpringApplication.run(EvnProjectApplication.class, args);
	}
}
