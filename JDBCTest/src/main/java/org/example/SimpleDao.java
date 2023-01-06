package org.example;

import java.sql.SQLException;
import java.util.ArrayList;

//인터페이스
public interface SimpleDao {
	public ArrayList<SimpleDto> list(String searchWord) throws SQLException;
	public ArrayList<SimpleDto> list() throws SQLException;
	public SimpleDto detail(int col_id) throws SQLException;
	public int delete(int colId) throws SQLException;
	public int update(SimpleDto dto) throws SQLException;
	public int insert(SimpleDto dto) throws SQLException;
	public int insertWithoutDefaultValue(SimpleDto dto) throws SQLException;
	public int insertDup(SimpleDto dto) throws SQLException;
	public int insert2(SimpleDto dto) throws SQLException;
}
