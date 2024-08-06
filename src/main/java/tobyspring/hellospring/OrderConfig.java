package tobyspring.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import tobyspring.hellospring.data.JdbcOrderRepository;
import tobyspring.hellospring.data.JpaOrderRepository;
import tobyspring.hellospring.order.OrderRepository;
import tobyspring.hellospring.order.OrderService;

import javax.sql.DataSource;

@Configuration
@Import(DataConfig.class) // OrderConfig를 로딩할 때, DataConfig의 설정정보들도 다 가져온다.
public class OrderConfig {

    @Bean
    public OrderRepository orderRepository(DataSource dataSource){
        return new JdbcOrderRepository(dataSource);
    }
    @Bean
    public OrderService orderService(PlatformTransactionManager transactionManager,OrderRepository orderRepository){
        return new OrderService(orderRepository,transactionManager);
    }


}
