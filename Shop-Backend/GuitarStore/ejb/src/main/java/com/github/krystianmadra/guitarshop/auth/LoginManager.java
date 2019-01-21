package com.github.krystianmadra.guitarshop.auth;


import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Startup
@Singleton
public class LoginManager {

    //@EJB
    //private UserStorage userStorage;

    private final Set<Token> storage;

    public LoginManager() {
        storage = new HashSet<>(); //todo czyszczenie niewaznych tokenow
    }

    public Long getUserIdFromToken(String aTokenFromClient) {
        Optional<Token> aToken = storage.stream().filter(token -> token.getToken().equals(aTokenFromClient)).findFirst();
        return aToken.map(Token::getUserId).orElse(null);
    }

    public boolean checkIfValidToken(String validatedToken){
        Optional<Token> storagedToken = storage.stream().filter(token -> token.getToken().equals(validatedToken)).findFirst();
        if(storagedToken.isPresent() && storagedToken.get().getExpirationDate().isAfter(LocalTime.now().plusHours(1))){
            return true;
        }
        return false;
    }

    public void saveNewToken(Token token){
        storage.add(token);
    }

    /*
    public String tryToLogin(String username, String password) {
        Token token = new Token(userStorage.tryToLogin(username,password));
        storage.add(token);
        return token.getToken();
    }
    */
}
