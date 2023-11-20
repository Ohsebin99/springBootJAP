package com.tjoeun.jpa.domain;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.beans.factory.annotation.Autowired;

import com.tjoeun.jpa.repository.MemberHistoryRepository;

//	Member Entity에 데이터가 입력될 때 또는 수정될 때 MemberHistoryListener의 메소드가 실행되야 하므로
//	Member Entity의 @EntityListeners 의 value 속성에 MemberHistoryListener.class를 추가한다.
public class MemberHistoryListener {
	
//	Entity Listener는 @Autowired로 bean을 자동으로 주입받지 못한다.
	@Autowired
	private MemberHistoryRepository memberHistoryRepository;
	
//	@PrePersist, @PreUpdate 어노테이션을 연달아 사용하면 insert, update전 모두 메소드가 실행된다.
	@PrePersist
	@PreUpdate
	public void prePersistAndPreUpdate(Object o) {
		System.out.println("MemberHistoryListener의 prePersistAndPreUpdate() 메소드");
		System.out.println(o.getClass().getName());
		
//		Entity listener는 @Autowired로 bean을 자동으로 주입받지 못하기 때문에 @Autowired를 사용한 경우
//		아래 print의 출력은 null이 출력된다.
		System.out.println("memberHistoryRepository" + memberHistoryRepository);
	}
	
	
}
