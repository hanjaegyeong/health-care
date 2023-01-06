package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

// 시작은 SimpleDao 이름으로 JDBC 진행, 테스트 코드 모두 완성하면 SimpleDao interface 만들고 SimpleDaoImpl 로 진행, main() SimpleDao dao = new SimpleDaoImpl();
// 테스트 코드는 아래 순서 대로
// insert() 
// insert2() : Statement
// insertDup()
// insertWithoutDefaultValue()
// 새로운 코드를 위로 올리면서
// update()
// delete()
// detail()
// list()
// list(searchWord)
public class SimpleDaoImpl implements SimpleDao{

	@Override
	public ArrayList<SimpleDto> list(String searchWord) throws SQLException{
		ArrayList<SimpleDto> list = new ArrayList<>();
		String sql = "select col_id, col_nm, col_not_null, col_default_val from jdbc_table " 
				+ " where col_nm like ? ";
		Connection con = DBManager.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "%" + searchWord + "%");
		
		ResultSet rset = pstmt.executeQuery(); // select
		while( rset.next() ) { // each row
			SimpleDto dto = new SimpleDto();
			dto.setColId(rset.getInt("col_id"));
			dto.setColNm(rset.getString("col_nm"));
			dto.setColNotNull(rset.getString("col_not_null"));
			dto.setColDefaultVal(rset.getString("col_default_val"));
			list.add(dto);
		}
		DBManager.releaseConnection(rset, pstmt, con);
		
		return list;
	}
	
	@Override
	public ArrayList<SimpleDto> list() throws SQLException{
		ArrayList<SimpleDto> list = new ArrayList<>();
		String sql = "select col_id, col_nm, col_not_null, col_default_val from jdbc_table ";
		Connection con = DBManager.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		ResultSet rset = pstmt.executeQuery(); // select
		while( rset.next() ) { // each row
			SimpleDto dto = new SimpleDto();
			dto.setColId(rset.getInt("col_id"));
			dto.setColNm(rset.getString("col_nm"));
			dto.setColNotNull(rset.getString("col_not_null"));
			dto.setColDefaultVal(rset.getString("col_default_val"));
			list.add(dto);
		}
		DBManager.releaseConnection(rset, pstmt, con);
		
		return list;
	}
	
	@Override
	public SimpleDto detail(int col_id) throws SQLException{ //한 건만 가져오기
		SimpleDto dto = null;
		String sql = "select col_id, col_nm, col_not_null, col_default_val from jdbc_table " +
					 " where col_id = ? ";
		Connection con = DBManager.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, col_id);
		
		ResultSet rset = pstmt.executeQuery(); // select
		if( rset.next() ) {
			dto = new SimpleDto();
			dto.setColId(rset.getInt("col_id"));
			dto.setColNm(rset.getString("col_nm"));
			dto.setColNotNull(rset.getString("col_not_null"));
			dto.setColDefaultVal(rset.getString("col_default_val"));
		}
		DBManager.releaseConnection(rset, pstmt, con);
		
		return dto;
	}
	
	@Override
	public int delete(SimpleDto dto) throws SQLException{
		int ret = -1;
		String sql = "delete from jdbc_table where col_id = ? "; //얘도 where조건 잘 주기
		Connection con = DBManager.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, dto.getColId());
		
		ret = pstmt.executeUpdate();
		DBManager.releaseConnection(pstmt, con);
		
		return ret;
	}
	
	@Override
	public int update(SimpleDto dto) throws SQLException{
		int ret = -1;
		String sql = "update jdbc_table set col_nm = ?, col_not_null = ?, "
					+ " col_default_val = ? where col_id = ? "; //where조건 빠지면 모든 데이터가 변경됨
		Connection con = DBManager.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, dto.getColNm()); //각 물음표 인덱스 지정해서 세팅
		pstmt.setString(2, dto.getColNotNull());
		pstmt.setString(3, dto.getColDefaultVal());
		pstmt.setInt(4, dto.getColId());
		
		ret = pstmt.executeUpdate();
		DBManager.releaseConnection(pstmt, con);
		
		return ret;
	}
	
	@Override
	public int insert(SimpleDto dto) throws SQLException{
		int ret = -1; //리턴값
		String sql = "insert into jdbc_table (col_nm, col_not_null, col_default_val) value (?, ?, ?)";
		Connection con = DBManager.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement(sql); //prepareStatement에 쿼리 전달해서 컴파일
		pstmt.setString(1, dto.getColNm());  //쿼리문의 value(?, ?, ?) 첫번째 물음표(index=1)에 삽입
		pstmt.setString(2, dto.getColNotNull());
		pstmt.setString(3, dto.getColDefaultVal());
		
		ret = pstmt.executeUpdate();
		DBManager.releaseConnection(pstmt, con); //항상 사용한 자원 반납
		
		return ret;
	}
	
	@Override
	public int insertWithoutDefaultValue(SimpleDto dto) throws SQLException{
		int ret = -1;
		String sql = "insert into jdbc_table (col_nm, col_not_null) value (?, ?)";
		Connection con = DBManager.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, dto.getColNm());
		pstmt.setString(2, dto.getColNotNull());
		//pstmt.setString(3, dto.getColDefaultVal());
		
		ret = pstmt.executeUpdate();
		DBManager.releaseConnection(pstmt, con);
		
		return ret;
	}
	
	@Override
	public int insertDup(SimpleDto dto) throws SQLException{
		int ret = -1;
		String sql = "insert into jdbc_table (col_id, col_nm, col_not_null, col_default_val) value (?, ?, ?, ?)";
		Connection con = DBManager.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, dto.getColId());
		pstmt.setString(2, dto.getColNm());
		pstmt.setString(3, dto.getColNotNull());
		pstmt.setString(4, dto.getColDefaultVal());
		
		ret = pstmt.executeUpdate();
		DBManager.releaseConnection(pstmt, con);
		
		return ret;
	}
	
	@Override
	public int insert2(SimpleDto dto) throws SQLException{
		int ret = -1;
		//String sql = "insert into jdbc_table (col_nm, col_not_null, col_default_val) value (?, ?, ?)";
		StringBuilder sql = new StringBuilder();
		sql.append("insert into jdbc_table (col_nm, col_not_null, col_default_val) value ('")
		   .append(dto.getColNm()).append("','")
		   .append(dto.getColNotNull()).append("','")
		   .append(dto.getColDefaultVal()).append("')");
		
		Connection con = DBManager.getConnection();
		
		Statement stmt = con.createStatement();

		
		ret = stmt.executeUpdate(sql.toString());
		DBManager.releaseConnection(stmt, con);
		
		return ret;
	}

}
