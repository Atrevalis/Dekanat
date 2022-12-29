package com.dekanat.dekanat.server.Utils;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;


public class Security {
    public static String hashPassword(String password){
        String sha256hex = Hashing.sha256()
                .hashString(password, StandardCharsets.UTF_8)
                .toString();
        return sha256hex;
    }
}
