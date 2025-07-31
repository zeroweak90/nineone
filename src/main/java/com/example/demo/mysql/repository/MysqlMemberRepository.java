package com.example.demo.mysql.repository;

import com.example.demo.mysql.entity.MysqlMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MysqlMemberRepository extends JpaRepository<MysqlMember, Long> {}
