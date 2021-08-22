package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages ="hello.core",
        //AppConfig 수동 등록 Bean 예외한다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes =Configuration.class)
)

public class AutoAppConfig {

}
