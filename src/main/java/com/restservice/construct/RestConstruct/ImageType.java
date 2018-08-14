package com.restservice.construct.RestConstruct;

public enum ImageType {
    CAR(1), WHEEL(2), STICKER(3);

    private final int type_id;
    ImageType(int type_id) {
        this.type_id = type_id;
    }

    public int getType_id() {
        return type_id;
    }
}
