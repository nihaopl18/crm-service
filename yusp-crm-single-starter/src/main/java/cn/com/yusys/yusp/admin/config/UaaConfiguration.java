package cn.com.yusys.yusp.admin.config;

import cn.com.yusys.yusp.uaa.security.UaaRedisTokenStore;
import cn.com.yusys.yusp.uaa.security.UaaWebResponseExceptionTranslator;
import cn.com.yusys.yusp.uaa.security.common.AuthoritiesConstants;
import cn.com.yusys.yusp.uaa.security.jwt.YuspJwtAccessTokenConverter;
import io.github.jhipster.config.JHipsterProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.CorsFilter;

import javax.servlet.http.HttpServletResponse;
import java.security.KeyPair;

@Configuration
@EnableAuthorizationServer
public class UaaConfiguration extends AuthorizationServerConfigurerAdapter {
    private final JHipsterProperties jHipsterProperties;
    @Autowired
    private RedisConnectionFactory connectionFactory;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    public UaaConfiguration(JHipsterProperties jHipsterProperties) {
        this.jHipsterProperties = jHipsterProperties;
    }

    @Bean
    public RedisTokenStore tokenStore() {
        return new RedisTokenStore(connectionFactory);
    }

    @Bean
    public UaaRedisTokenStore uaaTokenStore() {
        return new UaaRedisTokenStore(connectionFactory);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		/*
		 * For a better client design, this should be done by a ClientDetailsService
		 * (similar to UserDetailsService).
		 */
//        clients.inMemory().withClient("web_app").scopes("openid").autoApprove(true)
//                .authorizedGrantTypes("implicit", "refresh_token", "password", "authorization_code").and()
//                .withClient(jHipsterProperties.getSecurity().getClientAuthorization().getClientId())
//                .secret(jHipsterProperties.getSecurity().getClientAuthorization().getClientSecret()).scopes("web-app")
//                .autoApprove(true).authorizedGrantTypes("client_credentials");

        clients.inMemory()
                .withClient("web_app").scopes("openid").secret(new BCryptPasswordEncoder().encode(""))
                .authorizedGrantTypes("implicit", "refresh_token", "password", "authorization_code").and()
                .withClient(jHipsterProperties.getSecurity().getClientAuthorization().getClientId())
                .secret(new BCryptPasswordEncoder().encode(jHipsterProperties.getSecurity().getClientAuthorization().getClientSecret())).scopes("web-app")
                .autoApprove(true).authorizedGrantTypes("client_credentials");
    }

    @Bean
    public WebResponseExceptionTranslator webResponseExceptionTranslator() {
        return new UaaWebResponseExceptionTranslator();
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager).tokenStore(uaaTokenStore())
                .accessTokenConverter(jwtAccessTokenConverter()).userDetailsService(userDetailsService)
                .exceptionTranslator(webResponseExceptionTranslator());
    }

    /**
     * This bean generates an token enhancer, which manages the exchange between JWT
     * acces tokens and Authentication in both directions.
     *
     * @return an access token converter configured with the authorization server's
     * public/private keys
     */
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        //JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        JwtAccessTokenConverter converter = new YuspJwtAccessTokenConverter();
        KeyPair keyPair = new KeyStoreKeyFactory(new ClassPathResource("keystore.jks"), "password".toCharArray())
                .getKeyPair("selfsigned");
        converter.setKeyPair(keyPair);
        return converter;
    }

    /**
     * Apply the token converter (and enhander) for token store.
     */

	/*
	 * @Bean public JwtTokenStore jwttokenStore() { return new
	 * JwtTokenStore(jwtAccessTokenConverter()); }
	 */

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
    }

    @EnableResourceServer
    public static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

        private final TokenStore tokenStore;

        private final JHipsterProperties jHipsterProperties;

        private final CorsFilter corsFilter;

        @Autowired
        private DaoAuthenticationProvider securityDaoAuthenticationProvider;

        public ResourceServerConfiguration(TokenStore tokenStore, JHipsterProperties jHipsterProperties,
                                           CorsFilter corsFilter) {
            this.tokenStore = tokenStore;
            this.jHipsterProperties = jHipsterProperties;
            this.corsFilter = corsFilter;
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.exceptionHandling()
//					.accessDeniedHandler(getAccessDeniedHandler())
                    .authenticationEntryPoint((request, response, authException) -> response
                            .sendError(HttpServletResponse.SC_UNAUTHORIZED))
                    .and().csrf().disable().addFilterBefore(corsFilter, UsernamePasswordAuthenticationFilter.class)
                    .headers().frameOptions().disable()
                    .and().sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and().authorizeRequests()
                    .antMatchers("/api/codeImage/**").permitAll()
                    .antMatchers("/oauth/token").permitAll()
                    .antMatchers("/api/SSO/testssoLogin").permitAll()
                    .antMatchers("/api/SSO/ssoLogin").permitAll()
                    .antMatchers("/api/todowork/querySSOService").permitAll()
                    .antMatchers("/api/adminsmlogicsys/logicsyskv").permitAll()
                    .antMatchers("/api/register").permitAll()
                    .antMatchers("/api/activate").permitAll()
                    .antMatchers("/api/authenticate").permitAll()
                    .antMatchers("/api/account/reset_password/init").permitAll()
                    .antMatchers("/api/account/reset_password/finish").permitAll()
                    .antMatchers("/api/profile-info").permitAll()
                    .antMatchers("/api/**").authenticated()
                    .antMatchers("/management/health").permitAll()
                    .antMatchers("/management/**").hasAuthority(AuthoritiesConstants.ADMIN)
                    .antMatchers("/v2/api-docs/**").permitAll()
                    .antMatchers("/swagger-resources/configuration/ui").permitAll()
                    .antMatchers("/swagger-ui/index.html").hasAuthority(AuthoritiesConstants.ADMIN);
            // .and()
            // .logout().logoutUrl("/api/logout")
            // logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            // .addLogoutHandler(new SecLogoutHandler()).logoutSuccessHandler(new
            // SecLogoutSuccessHandler())
            // .and()
            // .authenticationProvider(securityDaoAuthenticationProvider);
        }


        /**
         * Inject your custom exception translator into the OAuth2 {@link AuthenticationEntryPoint}.
         *
         * @return AuthenticationEntryPoint
         */
        /*@Bean
		public AuthenticationEntryPoint authenticationEntryPoint() {
			final OAuth2AuthenticationEntryPoint entryPoint = new OAuth2AuthenticationEntryPoint();
			entryPoint.setExceptionTranslator(exceptionTranslator());
			return entryPoint;
		}*/

        /**
         * Classic Spring Security stuff, defining how to handle {@link AccessDeniedException}s.
         * Inject your custom exception translator into the OAuth2AccessDeniedHandler.
         * (if you don't add this access denied exceptions may use a different format)
         *
         * @return AccessDeniedHandler
         */
	/*	@Bean
		public AccessDeniedHandler accessDeniedHandler() {
			final OAuth2AccessDeniedHandler handler = new OAuth2AccessDeniedHandler();
			handler.setExceptionTranslator(exceptionTranslator());
			return handler;
		}*/
        @Override
        public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
            resources.resourceId("jhipster-uaa").tokenStore(tokenStore);
					/*.accessDeniedHandler(accessDeniedHandler())
					.authenticationEntryPoint(authenticationEntryPoint());*/
        }
    }
}
