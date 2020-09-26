package com.dairna.test;

import com.dairna.config.JavaConfig;
import com.dairna.po.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试类
 * Created by @Author darian on 2020/9/26
 */
public class Test {

	public static void main(String[] args) {
		// spring 注解式编程容器
		AnnotationConfigApplicationContext context = new
				AnnotationConfigApplicationContext(JavaConfig.class);
		User user = (User)context.getBean("user");
		user.setId("NO.1").setUserName("DarianSAMA");
		System.err.println(user.toString());

		// 没有报错，打印结果正确。spring 源码项目阅读环境就搭建好了
	}

}
