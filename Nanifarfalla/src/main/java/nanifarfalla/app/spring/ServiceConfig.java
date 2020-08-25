package nanifarfalla.app.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "nanifarfalla.app.service" })
public class ServiceConfig {
}
