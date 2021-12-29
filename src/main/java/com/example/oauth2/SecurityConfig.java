/*
 * @created 29/12/2021 - 3:32 PM
 * @author vanha
 */

package com.example.oauth2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;

@Configuration
@EnableWebSecurity(debug = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public ClientRegistrationRepository clientRepository() {
         ClientRegistration c = siteOauth2();
        return new InMemoryClientRegistrationRepository(c);
    }

    private ClientRegistration siteOauth2(){
        return CommonOAuth2Provider.GITHUB
                .getBuilder("github")
                .clientId("490764359fbb16dd1aa6")
                .clientSecret("967765c8caa40c5c885dc7268bef96e52a335d81")
                .build();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.oauth2Login(c->c.clientRegistrationRepository(clientRepository()));
        http.authorizeRequests().anyRequest().authenticated();
    }
}
