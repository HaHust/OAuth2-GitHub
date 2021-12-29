/*
 * @created 29/12/2021 - 3:31 PM
 * @author vanha
 */

package com.example.oauth2;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Oauth2Controller {
    @GetMapping("h")
    public String h(OAuth2AuthenticationToken auth){
        return "hello world " + auth.toString();
    }

    @GetMapping("b")
    public String b(){
        return "bye. ";
    }

}
