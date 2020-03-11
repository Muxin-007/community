package muxin.community.community.controller;

import muxin.community.community.dto.AccessTokeDTO;
import muxin.community.community.dto.GiteeUser;
import muxin.community.community.provider.GiteeProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.*;

@Controller
public class AuthorizeController {

    @Autowired
    private GiteeProvider giteeProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state){
        AccessTokeDTO accessTokeDTO = new AccessTokeDTO();
        accessTokeDTO.setClient_id("3f9b68767412d97b0be63b154c52ae5070a6666e6ee8be2dbef4d47136eb43ce");
        accessTokeDTO.setClient_secret("2dd64d3a8d69dafc7088dc78ac9d5f53ebedf6334f996ad40cbd99a21c03c715");
        accessTokeDTO.setCode(code);
        accessTokeDTO.setRedirect_uri("http://localhost:8887/callback");
        accessTokeDTO.setState(state);
        String accessToken = giteeProvider.getAccessToken(accessTokeDTO);
        GiteeUser user = giteeProvider.getUser(accessToken);
        return "index";
    }
}
