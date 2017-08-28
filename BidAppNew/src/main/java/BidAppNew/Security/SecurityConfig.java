//package BidAppNew.Security;
//
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    protected void configure(AuthenticationManagerBuilder amb) throws Exception {
//        amb.inMemoryAuthentication().withUser("user").password("password")
//                .roles("USER").and().withUser("help").password("please").roles("ADMIN");
//    }
//
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.httpBasic().and().authorizeRequests().antMatchers("/secrest/**")
//                .hasRole("USER").and().csrf().disable().headers().frameOptions().disable();
//    }
//    //test
//    //a change
//
//}
