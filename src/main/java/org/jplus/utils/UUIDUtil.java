package org.jplus.utils;

import java.util.UUID;

/**
 * @author imlgw.top
 * @date 2019/10/31 18:06
 */
public class UUIDUtil {

    public static String getUuid(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
