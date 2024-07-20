package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StateFullServiceTest {

    @Test
    void stateFulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StateFullService stateFullService1 = ac.getBean(StateFullService.class);
        StateFullService stateFullService2 = ac.getBean(StateFullService.class);

        stateFullService1.order("userA", 1000);
        stateFullService1.order("userB", 2000);
        // ThreadA가 사용자A 주문 금액 조회 
        
        int price = stateFullService1.getPrice();
        System.out.println("price = " + price);

        Assertions.assertThat(stateFullService1.getPrice()).isEqualTo(2000);

    }

    static class TestConfig{
        @Bean
        public StateFullService stateFullService(){
            return new StateFullService();
        }
    }
}