package com.mashup.feelring.config.security;

import com.mashup.feelring.exception.BusinessException;
import com.mashup.feelring.exception.ErrorCode;
import com.mashup.feelring.user.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UsernameAuthenticationProvider implements AuthenticationProvider {

    private final PrincipalDetailsService detailsService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String userId = authentication.getName();
        String password = (String) authentication.getCredentials();

        PrincipalDetails principal = (PrincipalDetails) detailsService.loadUserByUsername(userId);
        UserEntity user = principal.getUser();

        if (!passwordEncoder.matches(password, principal.getPassword())) {
            throw BusinessException.from(ErrorCode.LOGIN_FAILED);
        }

        final UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                userId,
                password,
                principal.getAuthorities()
        );
        token.setDetails(user.getId());

        return token;
    }
}
