package com.testcode.practice.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/*
* DB Layer 접근자
* ibatis, MyBatis에서는 Dao라고 불리고,
* JPA에선 Repository라고 부르며 인터페이스로 생성
* 인터페이스 생성 후 JpaRepository<Entity클래스, PK타입>을 상속하면 기본적인 CRUD 메소드가 자동으로 생성
* @Repository를 추가할 필요도 없고,
* Entity클래스와 기본 Entity Repository는 함께 위치해야 한다.
* 나중에 프로젝트 규모가 커져 도메인별로 프로젝트를 분리해야 한다면
* 이때 Entity 클래스와 기본 Repository는 함께 움직여야 하므로 도메인 패키지에서 함께 관리
* */
public interface PostsRepository extends JpaRepository<Posts, Long> {
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
