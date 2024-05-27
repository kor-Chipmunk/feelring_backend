package com.mashup.feelring.config.jwt;

import com.mashup.feelring.config.security.PrincipalDetails;
import com.mashup.feelring.config.security.UserDetailsToken;
import com.mashup.feelring.exception.BusinessException;
import com.mashup.feelring.exception.ErrorCode;
import com.mashup.feelring.user.UserEntity;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {

    private final UserDetailsService detailsService;
    private final JwtService jwtService;

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.isInstance(JwtAuthenticationToken.class);
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        final String token = (String) authentication.getPrincipal();

        final Claims jwtPayload = jwtService.getPayload(token);
        final String userId = jwtPayload.getSubject();
        final long id = jwtPayload.get("id", Long.class);

        PrincipalDetails principal = (PrincipalDetails) detailsService.loadUserByUsername(userId);
        UserEntity user = principal.getUser();

        if (user.getId() != id) {
            throw BusinessException.from(ErrorCode.USER_NOT_FOUND);
        }

        return new UserDetailsToken(
                principal,
                principal.getPassword()
        );
    }
}
