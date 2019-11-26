package com.darian.spring5testdemo;



import com.darian.spring5testdemo.domain.User;
import com.darian.spring5testdemo.service.UserRemoteService;
import com.darian.spring5testdemo.service.UserServiceJUnit5Test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Spring5TestDemoApplicationTests {

	@Test
	public void contextLoads() {

	}

    @Configuration
    public static class MockConfiguration {
        // Mock UserRemockService 作为 Spring Bean
        @Bean
        public UserRemoteService userRemoteService() {
            UserRemoteService userRemoteService = Mockito.mock(UserRemoteService.class);
            Mockito.when(userRemoteService.findAll()).thenReturn(
                    Arrays.asList(new User(1L, "darian"), new User(2L, "dairna2")));
            return userRemoteService;
        }
    }

}
