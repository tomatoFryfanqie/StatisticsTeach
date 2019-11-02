package org.jplus.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author imlgw.top
 * @date 2019/10/31 17:47
 */
public class MD5Util {

    public static String md5(String src) {
        return DigestUtils.md5Hex(src);
    }

    public static void main(String[] args) {
    }
}
