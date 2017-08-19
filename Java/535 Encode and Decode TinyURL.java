
// 535. Encode and Decode TinyURL

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-8-19 17:20:00
 * @url:https://leetcode.com/problems/encode-and-decode-tinyurl/description/
 */

public class Codec {

    private Map<Integer, String> smap;
    private Map<String, Integer> lmap;
    private String s;
    private int COUNT;
    private String BASEHOST;

    public Codec() {
        smap = new HashMap<Integer, String>();
        lmap = new HashMap<String, Integer>();
        s = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        COUNT = 1;
        BASEHOST = "http://tinyurl.com/";
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (lmap.containsKey(longUrl)) {
            return BASEHOST + base10ToBase62(lmap.get(longUrl));
        }
        String shortUrl = BASEHOST + base10ToBase62(COUNT);
        smap.put(COUNT, longUrl);
        lmap.put(longUrl, COUNT);
        COUNT++;
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String currUrl = shortUrl.substring(BASEHOST.length());
        Integer count = base62ToBase10(currUrl);
        return smap.get(count);
    }

    private String base10ToBase62(int count) {
        StringBuilder sb = new StringBuilder();
        while (count > 0) {
            int temp = count % 62;
            count /= 62;
            sb.append(String.valueOf(s.charAt(temp)));
        }
        while (sb.length() < 6) {
            sb.append("0");
        }
        return sb.reverse().toString();
    }

    private Integer base62ToBase10(String url) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        int len = url.length();
        int base = 1;
        for (int i = len - 1; i >= 0; i--) {
            count += convertc(url.charAt(i)) * base;
            base *= 62;
        }
        return count;
    }

    private Integer convertc(char c) {
        if (c >= '0' && c <= '9') {
            return (int) (c - '0');
        }
        if (c >= 'a' && c <= 'z') {
            return c - 'a' + 10;
        }
        if (c >= 'A' && c <= 'Z') {
            return c - 'A' + 36;
        }
        return 0;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));