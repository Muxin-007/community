package muxin.community;

public enum CommentTyoeEnum {
    QUESTION(1),
    COMMENT(2)
    ;
    private Integer type;
    public Integer getType() {
        return type;
    }

    CommentTyoeEnum(Integer type) {
        this.type = type;
    }

    public static boolean isExist(Integer type) {
        for (CommentTyoeEnum commentTyoeEnum : CommentTyoeEnum.values()) {
            if (commentTyoeEnum.getType() == type) {
                return true;
            }
        }
        return false;
    }
}
