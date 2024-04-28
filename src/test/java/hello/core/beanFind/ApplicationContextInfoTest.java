package hello.core.beanFind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean(){
        String[] beanDfinitionNames = ac.getBeanDefinitionNames();
        for(String beanDfinitionName : beanDfinitionNames){
            Object beand = ac.getBean(beanDfinitionName);
            System.out.println("beanDfinitionName==>>>" + beanDfinitionName + "object ==> " + beand);
        }
    }


    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean(){
        String[] beanDfinitionNames = ac.getBeanDefinitionNames();
        for(String beanDfinitionName : beanDfinitionNames){
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDfinitionName);

            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                Object beand = ac.getBean(beanDfinitionName);
                System.out.println("beanDfinitionName==>>>" + beanDfinitionName + "object ==> " + beand);
            }
        }
    }

}
