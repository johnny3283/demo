package com.member.model;

public interface MemHolder {
    void put(String key, MemberVO member);

    MemberVO get(String key);

    void remove(String key);
}
