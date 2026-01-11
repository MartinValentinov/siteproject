package com.example.mysite.websocket;

import com.example.mysite.model.MyUserDetailService;
import com.example.mysite.webtoken.JwtService;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.List;
import java.util.Map;

@Component
public class JwtHandshakeInterceptor implements HandshakeInterceptor {

    private final JwtService jwtService;
    private final MyUserDetailService userDetailService;

    public JwtHandshakeInterceptor(JwtService jwtService,
                                   MyUserDetailService userDetailService) {
        this.jwtService = jwtService;
        this.userDetailService = userDetailService;
    }

    @Override
    public boolean beforeHandshake(
            ServerHttpRequest request,
            ServerHttpResponse response,
            WebSocketHandler wsHandler,
            Map<String, Object> attributes) throws Exception {

        List<String> authHeaders = request.getHeaders().get("Authorization");

        if (authHeaders == null || authHeaders.isEmpty()) {
            return false;
        }

        String token = authHeaders.get(0);

        if (!token.startsWith("Bearer ")) {
            return false;
        }

        token = token.substring(7);

        String username = jwtService.extractUsername(token);

        if (username == null || !jwtService.isTokenValid(token)) {
            return false;
        }

        UserDetails userDetails = userDetailService.loadUserByUsername(username);

        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );

        attributes.put("user", authentication);

        return true;
    }

    @Override
    public void afterHandshake(
            ServerHttpRequest request,
            ServerHttpResponse response,
            WebSocketHandler wsHandler,
            Exception exception) {
    }
}