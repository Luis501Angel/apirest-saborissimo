package com.solcov.api.administrator;

import com.google.common.hash.Hashing;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@EnableAutoConfiguration
public class ControllerAdministrator {

    @Autowired
    private IRepositoryAdministrator repositoryUser;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "Inicio de sesion como administrador", notes = "Inicia sesion con nombre de usuario y contraseña")
    public Map<String, String> login(@RequestParam("username") String username, @RequestParam("password") String password) {
        String sha256pass = Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();
        List<Administrator> lstAdminExist = repositoryUser.findByUsername(username);
        HashMap<String, String> map = new HashMap<>();
        System.out.println(sha256pass);
        if(lstAdminExist.isEmpty()) {
            map.put("message", "El nombre del administrador esta incorrecto");
        } else {
            if(lstAdminExist.get(0).getPassword().equals(sha256pass)){
                map.put("key", getJWTToken(username));
                return map;
            }
        }
        map.put("message", "Contraseña incorrecta");
        return map;
    }

    private String getJWTToken(String username) {
        String secretKey = "solcov_secret";

        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("solcovJWT")
                .setSubject(username)
                .claim("authorities", grantedAuthorities.stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 6000000)) // 1 hora
                .signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();

        return token;
    }
}