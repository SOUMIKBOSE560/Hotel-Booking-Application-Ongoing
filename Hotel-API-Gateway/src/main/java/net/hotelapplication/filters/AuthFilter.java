package net.hotelapplication.filters;

import net.hotelapplication.services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Component
public class AuthFilter extends AbstractGatewayFilterFactory<AuthFilter.Config> {

    @Autowired
    private RouteValidator validator;

    @Autowired
    private RestTemplate template;

    @Autowired
    private JwtService jwtService;


    public AuthFilter() {
        super(Config.class);
    }


    //WEB FLUX DEPENDENCY
    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            if (validator.isSecured.test(exchange.getRequest())) {
                if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                    throw new RuntimeException("AUTHORIZATION HEADER IS MISSING");
                }
                String authorizationHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
                String token = null;
                if (authorizationHeader != null && authorizationHeader.startsWith("Bearer")) {
                    token = authorizationHeader.substring(7);
                }

                //VALIDATE TOKEN
                try {
                    jwtService.validateToken(token);
                } catch (Exception e) {
                    System.out.println("STACK TRACE : " + e.getMessage());
                    throw new RuntimeException("UNAUTHORIZED USER ACCESS");
                }
            }
            return chain.filter(exchange);
        });
    }

    public static class Config {

    }
}
