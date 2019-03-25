package com.ben.leetcode.design;

import java.util.HashMap;
import java.util.Map;

public class _535_Encode_and_Decode_TinyURL {
    static class Codec {

        private Map<String, String> map = new HashMap<>();

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            String tinyUrl = "http://tinyurl.com/" + longUrl.hashCode();
            map.put(tinyUrl, longUrl);
            return tinyUrl;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return map.get(shortUrl);
        }
    }

    static class Codec1 {
        private static final String BASE_HOST = "http://tinyurl.com/";
        private static final int BASE_HOST_LEN = BASE_HOST.length();
        private static final int TOTAL_LEN = BASE_HOST_LEN + 6;
        private static final String SEED = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        private Map<String, String> keyToUrl = new HashMap<>();
        private Map<String, String> urlToKey = new HashMap<>();

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            if (urlToKey.containsKey(longUrl)) {
                return BASE_HOST + urlToKey.get(longUrl);
            }

            String key = null;
            do {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 6; i++) {
                    int r = (int) (Math.random() * SEED.length());
                    sb.append(SEED.charAt(r));
                }
                key = sb.toString();
            } while (keyToUrl.containsKey(key));

            keyToUrl.put(key, longUrl);
            urlToKey.put(longUrl, key);
            return BASE_HOST + key;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            if (shortUrl == null || shortUrl.length() != TOTAL_LEN)
                return null;
            if (!shortUrl.startsWith(BASE_HOST))
                return null;

            String tinyUrl = shortUrl.substring(BASE_HOST_LEN);
            return keyToUrl.get(tinyUrl);
        }
    }
}
