package br.com.caelum.fj27.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


public class Password {

    private String password;
    private static PasswordEncoder encoder = new BCryptPasswordEncoder();

    private Password(String password) {
        this.password = password;
    }

    public String encoded() {
        return encoder.encode(password);
    }

    public String raw(){
        return password;
    }

    public static Password of(String rawPassword){
        return new Password(rawPassword);
    }

}
