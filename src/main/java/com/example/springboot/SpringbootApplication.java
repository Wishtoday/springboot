package com.example.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class SpringbootApplication {
//	private static final Logger log = (Logger) LoggerFactory.getLogger(SpringbootApplication.class);

	public static void main(String[] args) throws UnknownHostException {

		//自动补全返回类型及变量快捷键 ctrl+alt+v
		//上下移动一行代码 Ctrl+Shift+上下键
		ConfigurableApplicationContext application = SpringApplication.run(SpringbootApplication.class, args);
		Environment env = application.getEnvironment();
		//网络协议
		String protocol = env.getProperty("server.ssl.key-store") !=null ? "https" : "http";
		String ip = InetAddress.getLocalHost().getHostAddress();
		String port = env.getProperty("server.port");
		log.info("\n----------------------------------------------------------\n\t" +
				"Application '{}' is running! Access URLs:\n\t" +
				"本地访问地址Local: \t\t{}://localhost:{}\n\t" +
				"外部访问地址External: \t{}://{}:{}\n\t" +
				"Profile(s):\t{}\n\t"+
				"Swagger文档: \t{}://{}:{}/swagger-ui.html\n" +
				"----------------------------------------------------------",
				env.getProperty("spring.application.name"),
				protocol,
				port,
				protocol,
				ip,
				port,
				env.getActiveProfiles(),
				protocol,
				ip,
				port
				);
	}

}
