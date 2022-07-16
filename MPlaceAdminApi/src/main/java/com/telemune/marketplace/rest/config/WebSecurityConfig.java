package com.telemune.marketplace.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.telemune.marketplace.rest.jwt.JwtAuthEntryPoint;
import com.telemune.marketplace.rest.jwt.JwtAuthTokenFilter;
import com.telemune.marketplace.rest.service.jwt.UserDetailsServiceImpl;

/**
 * Manjeet Kumar
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	UserDetailsServiceImpl userDetailsService;

	@Autowired
	private JwtAuthEntryPoint unauthorizedHandler;

	@Bean
	public JwtAuthTokenFilter authenticationJwtTokenFilter() {
		return new JwtAuthTokenFilter();
	}

	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable().authorizeRequests().antMatchers("/api/auth/signin").permitAll()
				.antMatchers("/api/version").permitAll()
				.antMatchers("/api/auth/report/custcare/user/succed/mplaceCustCareUserTransaction.csv").permitAll()
				.antMatchers("/api/auth/report/custcare/user/all/mplaceCustCareUserAllTransaction.csv").permitAll()

				.antMatchers("/api/auth/report/packpurchase/download/packagesPurchaseReport.csv").permitAll()
				.antMatchers("/api/auth/report/revenue/download/revenueReport.csv").permitAll()
				.antMatchers("/api/auth/report/pack/alert/download/packAlertReport.csv").permitAll()
				.antMatchers("/api/auth/report/product/purchase/filter/date/productPurchaseReport.csv").permitAll()
				.antMatchers(
						"/api/auth/report/custcare/total/usageReport/filter/date/mplaceCustCareTotalUsageReport.csv")
				.permitAll().antMatchers("/api/auth/report/custcare/tps/mplaceCustCareTpsReport.csv").permitAll()
				.antMatchers("/api/auth/report/custcare/retention/filter/date/mplaceCustCareRetentionReport.csv")
				.permitAll().antMatchers("/api/auth/report/custcare/cdr/filter/date/custCareCdrReport.csv").permitAll()
				.anyRequest().authenticated().and().exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
				.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	}
}