package org.example;

import java.util.ArrayList;

//실행했을때 변동사항 없으면 콘솔에 0, 있으면 1 리턴 ex) col_id 3인 애 delete보냈는데 col_id 3이 없는 경우 0리턴
public class JDBCClient {

	public static void main(String[] args) throws Exception{
		// Connection 객체 사용, 종료 => dao, DBManager

		Class.forName("com.mysql.cj.jdbc.Driver");
		
		SimpleDao dao = new SimpleDaoImpl();
		
		//클라이언트가 값 던지면 DAO가 DB로 인서트
//		SimpleDto dto = new SimpleDto("정길동", "not null", "기본값"); //DTO가 내부로직수행
//		System.out.println( dao.insert(dto) ); // DAO(레포지토리)가 DB에 저장

//		SimpleDto dto = new SimpleDto(1, "홍길동", "not null", "기본값");
//		System.out.println( dao.insertDup(dto) );
		
//		SimpleDto dto = new SimpleDto("박길동", "not null", "기본값");
//		System.out.println( dao.insertWithoutDefaultValue(dto) ); //값이 안들어올때 default value 설정
		//insertWithoutDefaultValue

		//3번째 컬럼 수정(update)
//		SimpleDto dto = new SimpleDto(3, "유길동", "not null 2", "기본값2");
//		System.out.println( dao.update(dto) );

		//delete
		//SimpleDto dto = new SimpleDto(2, "유길동", "not null 2", "기본값2");
//		System.out.println( dao.delete(2) ); //delete 로직 수정: dto객체->int값 바로 받기

		//detail: DB에서 데이터 한 건 가져오기
//		SimpleDto dto = dao.detail(1);
//		System.out.println(dto);
	
	    //DB에서 데이터 리스트 전체 가져오기
//		ArrayList<SimpleDto> list = dao.list();
//		for (SimpleDto dto : list) {
//			System.out.println(dto);
//		}

		//특정 조건으로 필터링할 리스트 전체 가져오기
//		ArrayList<SimpleDto> list = dao.list("길동"); //길동 포함하는 모든 리스트
//		for (SimpleDto dto : list) {
//			System.out.println(dto);
//		}
	}
}

