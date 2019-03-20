package com.github.krystianmadra.guitarshop.auth;

import javax.annotation.Priority;
import javax.ejb.EJB;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Secured
@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {

    @EJB
    LoginManager loginManager;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

        if(authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")){
            throw new NotAuthorizedException("Authorization header is not provided!");
        }

        String token = authorizationHeader.substring("Bearer".length()).trim();

        try {
            validateToken(token);
        } catch (Exception exc){
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
        }
    }

    private void validateToken(String token) throws Exception {
        if(!loginManager.checkIfValidToken(token)){
            throw new IllegalTokenException("Token is invalid!");
        }
    }
}
