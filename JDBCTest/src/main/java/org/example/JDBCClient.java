package org.example;

import java.util.ArrayList;

public class JDBCClient {

	public static void main(String[] args) throws Exception{
		// Connection 객체 사용, 종료 => dao, DBManager

		Class.forName("com.mysql.cj.jdbc.Driver");
		
		SimpleDao dao = new SimpleDaoImpl();
		
		//클라이언트가 값 던지면
		SimpleDto dto = new SimpleDto("홍길동", "not null", "기본값"); //DTO가 내부로직수행
		System.out.println( dao.insert(dto) ); // DAO(레포지토리)가 DB에 저장

//		SimpleDto dto = new SimpleDto(1, "홍길동", "not null", "기본값");
//		System.out.println( dao.insertDup(dto) );
		
//		SimpleDto dto = new SimpleDto("박길동", "not null", "기본값");
//		System.out.println( dao.insertWithoutDefaultValue(dto) ); //값이 안들어올때 default value 설정
		//insertWithoutDefaultValue
		
//		SimpleDto dto = new SimpleDto(3, "유길동", "not null 2", "기본값2");
//		System.out.println( dao.update(dto) );
		
//		SimpleDto dto = new SimpleDto(3, "유길동", "not null 2", "기본값2");
//		System.out.println( dao.delete(dto) );
		
//		SimpleDto dto = dao.detail(5);
//		System.out.println(dto);
		
//		ArrayList<SimpleDto> list = dao.list();
//		for (SimpleDto dto : list) {
//			System.out.println(dto);
//		}
//
//		ArrayList<SimpleDto> list = dao.list("ssafy");
//		for (SimpleDto dto : list) {
//			System.out.println(dto);
//		}		
	}

}

