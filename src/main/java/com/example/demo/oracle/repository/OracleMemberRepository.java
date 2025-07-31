package com.example.demo.oracle.repository;

import com.example.demo.oracle.entity.OracleMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OracleMemberRepository extends JpaRepository<OracleMember, Long> {}
