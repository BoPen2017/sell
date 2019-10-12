package com.zero.utils;

import com.zero.enums.CodeEnum;

/**
 * Created by asd on 2019/10/11.
 */
public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code,Class<T> enumClass) {
        for (T each: enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
