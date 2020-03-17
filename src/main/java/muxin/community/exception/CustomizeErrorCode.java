package muxin.community.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode {

    QUESTION_NOT_FOUND(2001,"你找到问题不在了，要不换一个？"),
    TARGET_PARAM_NOT_FOUND(2002,"未选中任何问题或评论进行恢复"),
    NO_LOGIN(2003, "未登录不能进行评论，请先登录"),
    SYS_ERROR(2004, "服务器繁忙，请稍后尝试！！！"),
    TYPE_PARAM_WRONG(2005, "评论类型错误或不存在"),
    COMMENT_NOT_FOUND(2006,"回复的评论不存在了，要不要换一个试试？")
    ;

    private Integer code;
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return null;
    }

    CustomizeErrorCode(Integer code, String message) {
        this.message = message;
        this.code = code;
    }


}
