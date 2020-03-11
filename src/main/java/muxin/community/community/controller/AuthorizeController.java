package muxin.community.community.controller;

import muxin.community.community.dto.AccessTokeDTO;
import muxin.community.community.dto.GithubUser;
import muxin.community.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state){
        AccessTokeDTO accessTokeDTO = new AccessTokeDTO();
        accessTokeDTO.setClient_id("74692b707d8e1210b46f");
        accessTokeDTO.setClient_secret("5e71a15104b6fedee85a475cb2868fdcaae5e26f");
        accessTokeDTO.setCode(code);
        accessTokeDTO.setRedirect_uri("http://localhost:8887/callback");
        accessTokeDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokeDTO);
        GithubUser user = githubProvider.getUser(accessToken);
        System.out.println(user.getName());
        return "index";
    }
}
