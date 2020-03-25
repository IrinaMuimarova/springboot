package springBoot.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {  // WebSecurityConfigurerAdapter базовый класс для создания экземпляра WebSecurityConfigurer, для кастомизации переопределяем методы


    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {//переопределенный метод для конфигурации аутентификации для разных источников(память, бд, LDAP, )
        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN"); //кастомизация на юзер дао и кодировка
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();             //использует для кодировки хешфункции
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {              //кастомизация работы с http запросыми
        http
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/api/**").hasAuthority("ROLE_ADMIN")
                .and()
                .csrf().disable()
                .formLogin().disable();
    }
}
