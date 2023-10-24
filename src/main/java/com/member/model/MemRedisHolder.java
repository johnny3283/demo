package com.member.model;

import com.google.gson.Gson;
import redis.clients.jedis.Jedis;

public class MemRedisHolder implements MemHolder {


    private static Jedis jedis = new Jedis("127.0.0.1", 6379);
    private Gson gson = new Gson();

    @Override
    public void put(String key, MemberVO member) {
        jedis.set(key, gson.toJson(member));
    }

    @Override
    public MemberVO get(String key) {
        return gson.fromJson(jedis.get(key), MemberVO.class);
    }

    @Override
    public void remove(String key) {
        jedis.del(key);
    }
}
