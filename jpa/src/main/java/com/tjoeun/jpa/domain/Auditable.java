package com.tjoeun.jpa.domain;

import java.time.LocalDateTime;

// MyEntityListener를 사용하는 Entity인가 식별하기 위해서 표시 인터페이스를 만든다.
public interface Auditable {
	
//	MyEntityListener 페이지에 get, set를 만들기
	LocalDateTime getCreateAt();
	LocalDateTime getUpdateAt();
	void setCreateAt(LocalDateTime createAt);
	void setUpdateAt(LocalDateTime updateAt);
}
