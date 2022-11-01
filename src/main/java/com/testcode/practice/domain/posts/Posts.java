package com.testcode.practice.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // 클래스 내 모든 필드의 Getter 메소드를 자동생성 Lombok 라이브러리
@NoArgsConstructor  // 기본 생성자 자동 추가 Lombok 라이브러리
@Entity // 테이블과 링크될 클래스임을 나타냄, 테이블 이름은 카멜케이스에서 소문자 언더스코어 네이밍으로 테이블 이름을 나타냄
public class Posts {

    /*
    * 되도록이면 Entity의 PK는 Long 타입의 auto_increment를 추천
    * 주민등록번호와 같이 비즈니스상 유니크 키나, 여러 키를 조합한 복합키로 PK를 잡을 경우 난감한 상황이 종종 발생
    * FK를 맺을 때 다른 테이블에서 복합키 전부를 갖고 있거나, 중간 테이블을 하나 더 둬야 하는 상황이 발생
    * 인덱스에 좋은 영향을 끼치지 못함
    * 유니크한 조건이 변경될 경우 PK 전체를 수정해야 하는 일이 발생
    * 주민등록번호, 복합키 등은 유니크 키로 별도로 추가하는 것을 추천
    * */
    @Id // 해당 테이블의 PK 필드를 나타냄

    /*
    - PK 생성 규칙을 나타냄
    - GenerationType.IDENTITY 옵션은 auto_increment가 됨
    * */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    /*
    * 테이블의 컬럼을 나타내며 굳이 선언하지 않아도 해당 클래스의 필드는 모두 컬럼이 된다.
    * 사용하는 이유는 기본값 외에 추가로 변경이 필요한 옵션이 있음녀 사용
    * VARCHAR는 기본 255크기, 사이즈를 500으로 늘릴수 있고, TEXT로 타입을 변경가능
    * */
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    /*
    Lombok 라이브러리
    * 해당 클래스의 빌더 패턴 클래스를 생성
    * 생성자 상단에 선언시 생성자에 포함된 필드만 빌더에 포함
    * */
    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    /*
    * Entity 클래스에서는 절대 Setter 메소드를 만들지 않는다.
    * 대신, 해당 필드의 값 변경이 필요하면 명확히 그 목적과 의도를 나타낼 수 있는 메소드를 추가해야만 한다.
    * Setter가 없는 상황에서는 기본적으로 생성자를 통해 최종값을 채운 후 DB에 삽입한다.
    * 값 변경이 필요한 경우 해당 이벤트에 맞는 public 메소드를 호출하여 변경하는 것을 전제로 한다.
    * */

}
