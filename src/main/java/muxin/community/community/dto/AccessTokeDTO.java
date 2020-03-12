package muxin.community.community.dto;

import lombok.Data;

@Data
public class AccessTokeDTO {
    private String client_id;
    private String client_secret;
    private String redirect_uri;
    private String code;
    private String state;
}
