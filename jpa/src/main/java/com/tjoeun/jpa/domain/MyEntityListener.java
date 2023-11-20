package com.tjoeun.jpa.domain;

import java.time.LocalDateTime;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class MyEntityListener {
	
//	Entity Listener가 여러 Entity에서 사용되므로 @PrePersist, @PreUpdate 메소드로 넘어오는 객체가
//	달라질 수 있기 때문에 모든 객체를 받아서 처리할 수 있도록 Object 타입으로 인수를 지정한다.
	
	@PrePersist
	public void prePersist(Object o) {
		System.out.println("MyEntityListener의 prePersist() 메소드");
		if(o instanceof Auditable) { // 형변환이 가능한지
//			get, set이 안 보이면 Auditable 폴더에서 만들기
			((Auditable) o).setCreateAt(LocalDateTime.now());
			((Auditable) o).setUpdateAt(LocalDateTime.now());
		}
	}
	
	@PreUpdate
	public void preUpdate(Object o) {
		System.out.println("MyEntityListener의 preUpdate() 메소드");
		if(o instanceof Auditable) { // 형변환이 가능한지
//			get, set이 안 보이면 Auditable 폴더에서 만들기
			((Auditable) o).setCreateAt(LocalDateTime.now());
			((Auditable) o).setUpdateAt(LocalDateTime.now());
		}
	}
	
}
