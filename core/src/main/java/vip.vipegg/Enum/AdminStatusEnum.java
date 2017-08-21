package vip.vipegg.Enum;

public enum AdminStatusEnum {

    NORMAL("正常"),FORBID("禁用");

    private String name;

    AdminStatusEnum() {
    }

    AdminStatusEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return this.ordinal();
    }

    public static AdminStatusEnum valueOf(int index) {
        for (AdminStatusEnum statusEnum : AdminStatusEnum.values()) {
            if (index == statusEnum.ordinal()) {
                return statusEnum;
            }
        }
        return null;
    }
}
