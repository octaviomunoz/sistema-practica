package com.practica.config;


import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.practica.service.UserServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    //Necesario para evitar que la seguridad se aplique a los resources
    //Como los css, imagenes y javascripts
    String[] resources = new String[]{
            "/static/**","/css/**","/fontawesome/**","/img/**","/js/**","/layer/**", "/bootstrap/**"
    };

    //Para que los recursos no esten restringidos
    @Override
    public void configure(WebSecurity web) throws Exception {
      web.ignoring().antMatchers(resources);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http
          .authorizeRequests()
	        //.antMatchers(resources).permitAll()
          .antMatchers("/").permitAll()
          .antMatchers("/alumno/mostrar", "/empresa/**").hasRole("ADMIN")
          .antMatchers("/alumno/**").hasRole("ALUMNO")
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/", true)
                .failureUrl("/login?error=true")
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
            .logout()
                .permitAll()
                .logoutSuccessUrl("/login?logout");

        //Si no tiene los permisos para etar en esa pagina lo redirecciona a el index
        http.exceptionHandling().accessDeniedPage("/");
    }


    BCryptPasswordEncoder bCryptPasswordEncoder;
    //Crea el encriptador de contraseñas
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
  		bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
      //El numero 4 representa que tan fuerte quieres la encriptacion.
      //Se puede en un rango entre 4 y 31.
      return bCryptPasswordEncoder;
    }

    @Autowired
    UserServiceImpl userDetailsService;

    //Registra el service para usuarios y el encriptador de contrasena
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
}
