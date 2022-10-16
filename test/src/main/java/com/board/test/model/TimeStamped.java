package com.board.test.model;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter            // 데이터를 가져갈 수 있도록 getter 를 설정해줘야 함
@MappedSuperclass // Entity 가 자동으로 컬럼으로 인식. 슈퍼클래스로 mapped 됨
@EntityListeners(AuditingEntityListener.class) // 생성 변경 시간을 자동 업데이트
public abstract class TimeStamped {

    @CreatedDate
    private LocalDateTime createdAt;

//    @LastModifiedDate
//    private LocalDateTime modifiedAt;

}
