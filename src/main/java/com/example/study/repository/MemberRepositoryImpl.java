package com.example.study.repository;

import com.example.study.entity.Member;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.example.study.entity.QMember.member;

// QueryDsl용 인터페이스의 구현체는 반드시 끝이 Impl로 끝나야 자동으로 인식되어서
// 원본 인터페이스(MemberREpository) 타입의 객체로도 사용이 가능하다.
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Member> findByName(String name) {
        return queryFactory
                .selectFrom(member)
                .where(member.userName.eq(name))
                .fetch();
    }



}