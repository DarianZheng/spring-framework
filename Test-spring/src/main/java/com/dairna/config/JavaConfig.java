package com.dairna.config;

import com.dairna.po.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * Created by @Author darian on 2020/9/26
 */
@Configuration
@ComponentScan
public class JavaConfig {

	@Bean
	public User user(){
		return new User();
	}

}
