package com.lad.springserver.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lad.springserver.controller.mapping.UserMapping;
import com.lad.springserver.model.dto.UserDto;
import com.lad.springserver.model.entity.Users;
import com.lad.springserver.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*@Configuration
@EnableWebSecurity
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().cors().disable().
                authorizeRequests().
                antMatchers("/").permitAll().
                antMatchers("/admin/**").hasAnyRole("ADMIN").
               *//* anyRequest().hasAnyRole("ADMIN").*//*
                and().
                formLogin().
               *//* loginPage("/login").*//*permitAll().and().httpBasic();

    }

}*/


@Configuration
@EnableWebSecurity
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {
    @Autowired
    UserService userService;

    @Autowired
    UserMapping userMapping;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {

        return new BCryptPasswordEncoder(4);
    }

   /* @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf()
                .disable()
                .authorizeRequests()
                //Доступ только для не зарегистрированных пользователей
                .antMatchers("/registration").not().fullyAuthenticated()
                //Доступ только для пользователей с ролью Администратор
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/news").hasRole("USER")
                //Доступ разрешен всем пользователей
                .antMatchers("/", "/resources/**").permitAll()
                //Все остальные страницы требуют аутентификации
                .anyRequest().authenticated()
                .and()
                //Настройка для входа в систему
                .formLogin()
                //Перенарпавление на главную страницу после успешного входа
                .defaultSuccessUrl("/")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/").and().httpBasic();
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder());
    }*/

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        //Valid config

        httpSecurity
                .csrf()
                .disable()
                .cors()
                .disable()
                .authorizeRequests()
                .antMatchers("/registration").not().fullyAuthenticated()
                .antMatchers("/user/**").hasRole("USER")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/performances/all").permitAll()
                .antMatchers(HttpMethod.GET, "/scenarists/all").permitAll()
                .antMatchers(HttpMethod.GET, "/actors/all").permitAll()
                .antMatchers(HttpMethod.GET, "/genres/all").permitAll()
                .antMatchers(HttpMethod.GET, "/performances/**").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/user/**").hasAnyRole("USER","ADMIN")
                .antMatchers("/", "/login", "/resources/**", "/js/**", "/ws/**").permitAll()
                .anyRequest().hasRole("ADMIN")
/*                .and()
                .formLogin()
                .loginPage("/login")
                .successHandler((request, response, exception) -> {
                    response.setStatus(HttpStatus.OK.value());
                    response.setHeader("Content-Type", "application/json");
                    UserDetails details = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                    UserDto authorizedUser = userMapping.entityToDto((Users) userService.loadUserByUsername(details.getUsername()));
                    PrintWriter pw = response.getWriter();
                    ObjectMapper om = new ObjectMapper();
                    String json = om.writeValueAsString(authorizedUser);
                    pw.print(json);
                })
                .failureHandler((request, response, exception) -> response.setStatus(HttpStatus.UNAUTHORIZED.value()))*/
                .and()
                .logout()
                .invalidateHttpSession(true)
                .permitAll()
                .logoutSuccessUrl("/")
                /*.and()
                .rememberMe().key("DeliveryServiceSecretKey")*/;

        //ПАРАША С ХАБРА
      /*  httpSecurity
                .csrf()
                .disable()
                .authorizeRequests()
                //Доступ только для не зарегистрированных пользователей
                .antMatchers("/registration").not().fullyAuthenticated()
                //Доступ только для пользователей с ролью Администратор
                .antMatchers("/admin/**").hasRole("ADMIN")
              //  .antMatchers("/user/**").hasRole("USER")
                //Доступ разрешен всем пользователей
                .anyRequest().permitAll().
                //Все остальные страницы требуют аутентификации
               // .anyRequest().authenticated()
                and()
                //Настройка для входа в систему
                .formLogin()
                .loginPage("/login")
                //Перенарпавление на главную страницу после успешного входа
                .defaultSuccessUrl("/")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/");*/

        //ЛОМАЙ МЕНЯ
    /*    httpSecurity
                .csrf()
                .disable()
                .cors()
                .disable()
                .authorizeRequests()
                //Доступ только для не зарегистрированных пользователей
                .antMatchers("/registration").not().fullyAuthenticated()
                .antMatchers("/user/profile").hasRole("USER")
                //    antMatchers("/performances/all").hasAnyRole("USER","ADMIN")
                //Доступ только для пользователей с ролью Администратор
                .antMatchers("/admin/**").hasRole("ADMIN")
                //Доступ разрешен всем пользователей
                .antMatchers("/", "/login").permitAll()
                //Все остальные страницы требуют аутентификации
                .anyRequest().hasRole("ADMIN")
                .and()
                //Настройка для входа в систему
                .formLogin().
                loginPage("/login")
                .successHandler((request, response, exception) -> {
                    response.setStatus(HttpStatus.OK.value());
                    response.setHeader("Content-Type", "application/json");
                    UserDetails details = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                    UserDto authorizedUser = userMapping.entityToDto((Users) userService.loadUserByUsername(details.getUsername()));
                    PrintWriter pw = response.getWriter();
                    ObjectMapper om = new ObjectMapper();
                    String json = om.writeValueAsString(authorizedUser);
                    pw.print(json);
                })
                .failureHandler((request, response, exception) -> response.setStatus(HttpStatus.UNAUTHORIZED.value()))
                .and()
                .logout()
                .invalidateHttpSession(true)
                .permitAll()
                .logoutSuccessUrl("/")
                .and()
                .rememberMe().key("DeliveryServiceSecretKey");*/
        //РАЗБЛОЧЬ МЕНЯ
    /*    httpSecurity
                .csrf()
                .disable()
                .cors()
                .disable()
                .authorizeRequests()
                //Доступ только для не зарегистрированных пользователей
                .antMatchers("/registration").not().fullyAuthenticated()
                .antMatchers("/user/profile").hasRole("USER")
            //    antMatchers("/performances/all").hasAnyRole("USER","ADMIN")
                //Доступ только для пользователей с ролью Администратор
                .antMatchers("/admin/**").hasRole("ADMIN")
                //Доступ разрешен всем пользователей
                .antMatchers("/", "/login").permitAll()
                //Все остальные страницы требуют аутентификации
                .anyRequest().hasRole("ADMIN")
                .and()
                //Настройка для входа в систему
                .formLogin().
                loginPage("/login")
                .successHandler((request, response, exception) -> {
                    response.setStatus(HttpStatus.OK.value());
                    response.setHeader("Content-Type", "application/json");
                    UserDetails details = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                    UserDto authorizedUser = userMapping.entityToDto((Users) userService.loadUserByUsername(details.getUsername()));
                    PrintWriter pw = response.getWriter();
                    ObjectMapper om = new ObjectMapper();
                    String json = om.writeValueAsString(authorizedUser);
                    pw.print(json);
                })
                .failureHandler((request, response, exception) -> response.setStatus(HttpStatus.UNAUTHORIZED.value()))
                .and()
                .logout()
                .invalidateHttpSession(true)
                .permitAll()
                .logoutSuccessUrl("/")
                .and()
                .rememberMe().key("DeliveryServiceSecretKey");*/
        //Test
//        httpSecurity
//                .csrf()
//                .disable()
//                .authorizeRequests()
//                .antMatchers("/**").permitAll()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .failureHandler(new AuthenticationFailureHandler() {
//
//                    @Override
//                    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
//                                                        AuthenticationException exception) throws IOException, ServletException {
//                        String email = request.getParameter("email");
//                        String error = exception.getMessage();
//                        System.out.println("A failed login attempt with email: "
//                                + email + ". Reason: " + error);
//
//                        String redirectUrl = request.getContextPath() + "/login?error=true";
//                        response.sendRedirect(redirectUrl);
//                    }
//                })
//                //Перенарпавление на главную страницу после успешного входа
//                .defaultSuccessUrl("/")
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll()
//                .logoutSuccessUrl("/");

    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder());
    }

  /*  private static class Http401UnauthorizedEntryPoint implements AuthenticationEntryPoint {

        public Http401UnauthorizedEntryPoint() {
        }

        public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException arg2) throws IOException {
            response.sendError(401, "You should login to get access");
        }
    }

    */
}
