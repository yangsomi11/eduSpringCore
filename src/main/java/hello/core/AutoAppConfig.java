package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
    //@ComponentScan 자동으로 @Component붙은 설정 정보를 등록
    //@Component, @Controller, @Sercive, @Repository, @Configration -> 모두 다 @Component 다 등록되어있음 
    //Filter로 이미 @Configuration 이 붙어있다면 자동 스캔에서 제외처리

}
