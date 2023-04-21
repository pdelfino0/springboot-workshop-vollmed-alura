package med.voll.api.infra.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        var tokenJWT = getTokenJWT(request);
        var subject = tokenService.getSubject(tokenJWT);

        System.out.println(subject);



        filterChain.doFilter(request, response);
    }

    private String getTokenJWT(HttpServletRequest request) {
        String tokenJWT = request.getHeader("Authorization");

        if (tokenJWT != null) return tokenJWT.replace("Bearer ", "");

        return null;
    }
}
