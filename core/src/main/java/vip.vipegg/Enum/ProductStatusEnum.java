package vip.vipegg.Enum;

public enum ProductStatusEnum {

    OFF("待上架"),ON("已上架");

    private String name;

    ProductStatusEnum() {
    }

    ProductStatusEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return this.ordinal();
    }

    public static ProductStatusEnum valueOf(int index) {
        for (ProductStatusEnum statusEnum : ProductStatusEnum.values()) {
            if (index == statusEnum.ordinal()) {
                return statusEnum;
            }
        }
        return null;
    }
}
