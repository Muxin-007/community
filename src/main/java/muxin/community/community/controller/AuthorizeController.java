package muxin.community.community.controller;

import muxin.community.community.dto.AccessTokeDTO;
import muxin.community.community.dto.GithubUser;
import muxin.community.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String clientId;

    @Value("${github.client.secret}")
    private String clientsecret;

    @Value("${github.redirect.uri}")
    private String redirectUri;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state){
        AccessTokeDTO accessTokeDTO = new AccessTokeDTO();
        accessTokeDTO.setClient_id(clientId);
        accessTokeDTO.setClient_secret(clientsecret);
        accessTokeDTO.setCode(code);
        accessTokeDTO.setRedirect_uri(redirectUri);
        accessTokeDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokeDTO);
        GithubUser user = githubProvider.getUser(accessToken);
        System.out.println(user.getName());
        return "index";
    }
}
