package tn.bal.pi.configuration;


import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import tn.bal.pi.repositories.UserRepository;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter  extends OncePerRequestFilter {

    private static final String BEARER ="Bearer " ;
    @Autowired
    private final JwtUtils jwtUtils;
    private final UserRepository userRepository;
    private final String AUTHORIZATION="Authorization";
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String authHeader= request.getHeader(AUTHORIZATION);
        String useremail;
        String jwt;
        if(authHeader==null && !authHeader.startsWith(BEARER)){
            filterChain.doFilter(request,response);
            return;
        }
        jwt=authHeader.substring(7);
        useremail= jwtUtils.extractUsername(jwt);
        if(useremail!=null && SecurityContextHolder.getContext().getAuthentication()==null){
            UserDetails userDetails = userRepository.findByEmail(useremail)
                    .orElseThrow(()-> new UsernameNotFoundException("no user was found while validating the jwt"));//we can change exception to entityNotFoundException
            if(jwtUtils.isTokenValid(jwt,userDetails)){
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                        = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }


    }
}
