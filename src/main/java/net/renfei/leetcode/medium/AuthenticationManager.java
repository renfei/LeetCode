package net.renfei.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 * | 1797. 设计一个验证系统
 * | https://leetcode-cn.com/problems/design-authentication-manager/
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 *
 * @author renfei
 */
public class AuthenticationManager {
    private final int TIME_TO_LIVE;
    private final Map<String, Integer> MAP;

    public AuthenticationManager(int timeToLive) {
        MAP = new HashMap<>();
        this.TIME_TO_LIVE = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        MAP.put(tokenId, currentTime);
    }

    public void renew(String tokenId, int currentTime) {
        if (MAP.containsKey(tokenId)) {
            int oldTime = MAP.get(tokenId);
            if (currentTime - oldTime < TIME_TO_LIVE) {
                MAP.put(tokenId, currentTime);
            }
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int total = 0;
        for (String key : MAP.keySet()
        ) {
            if (currentTime - MAP.get(key) < TIME_TO_LIVE) {
                total++;
            }
        }
        return total;
    }

}
