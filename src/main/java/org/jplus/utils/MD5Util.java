package org.jplus.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Util {

    public static String md5(String src) {
        return DigestUtils.md5Hex(src);
    }

    public static void main(String[] args) {
    }
}
