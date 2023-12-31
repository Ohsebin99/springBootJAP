package com.tjoeun.jpa.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
//	@EntityListeners 으로 사용할 Entity Listener를 지정한다.
@EntityListeners(value = MyEntityListener.class)
//	Audibtable 인터페이스의 추상 메소드는 Override 하지 않아도 @Data 처리 된다.
public class Book implements Auditable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String name;
	private String author;
	private LocalDateTime createAt;
	private LocalDateTime updateAt;
	
//	대부분의 Entity는 Book Entity의 prePersist(),preUpdate() 메소드와 같은 작성일과 수정일을 저장하는
//	메소드가 필요할 것이다.
//	매번 Entity를 생성할 때 마다 prePersist(), preUpdate() 메소드를 만들어서 사용해도 되지만 같은 작업이
//	반복되므로 코드 리펙토링 차원에서 Entity Listener를 지정해서 사용하는 것을 권장한다.
	
//	Entity Listener를 지정했으므로 prePersist(), preUpdate() 메소드는 제거한다.
//	@PrePersist
//	public void prePersist() {
//		createAt = LocalDateTime.now();
//		updateAt = LocalDateTime.now();
//		
//	}
	
//	@PreUpdate
//	public void preUpdate() {
//		updateAt = LocalDateTime.now();
//		
//	}
}
