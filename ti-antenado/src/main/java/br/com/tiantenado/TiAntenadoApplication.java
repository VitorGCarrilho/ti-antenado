package br.com.tiantenado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@EnableTransactionManagement
@ComponentScan
@EnableJpaRepositories
@ImportResource("classpath*:/spring/spring-beans-config.xml")
public class TiAntenadoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiAntenadoApplication.class, args);
	}
}