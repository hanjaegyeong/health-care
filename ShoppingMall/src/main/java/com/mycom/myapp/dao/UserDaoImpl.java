package com.mycom.myapp.dao;

import com.mycom.myapp.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Repository
public class UserDaoImpl implements UserDao{
    @Autowired
    DataSource dataSource;

    @Override
    public int userRegister(UserDto userDto) {
        Connection con = null;
        PreparedStatement pstmt = null;

        int ret = -1;

        try {

            con = dataSource.getConnection();

            // 이미지, 가입일시는 테이블 컬럼 기본값으로 처리
            StringBuilder sb = new StringBuilder();
            sb.append("insert into users ( user_name, user_password, user_email ) ");
            sb.append("  values ( ?, ?, ? ) ");

            pstmt = con.prepareStatement(sb.toString());

            pstmt.setString(1, userDto.getUserName());
            pstmt.setString(2, userDto.getUserPassword());
            pstmt.setString(3, userDto.getUserEmail());

            ret = pstmt.executeUpdate();

        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if( pstmt != null ) pstmt.close();
                if( con != null ) con.close();
            }catch(Exception e) {
                e.printStackTrace();
            }
        }

        return ret;
    }

    @Override
    public UserDto login(String userEmail) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        UserDto userDto = null;

        try {

            con = dataSource.getConnection();

            StringBuilder sb = new StringBuilder();
            sb.append("select user_seq, user_name, user_password, user_email, user_profile_image_url, user_register_date ");
            sb.append("  from users ");
            sb.append(" where user_email = ? ");

            pstmt = con.prepareStatement(sb.toString());
            pstmt.setString(1, userEmail);

            rs = pstmt.executeQuery();

            if( rs.next() ) {
                userDto = new UserDto();
                userDto.setUserSeq(rs.getInt("user_seq"));
                userDto.setUserName(rs.getString("user_name"));
                userDto.setUserPassword(rs.getString("user_password"));
                userDto.setUserEmail(rs.getString("user_email"));
                userDto.setUserProfileImageUrl(rs.getString("user_profile_image_url"));
            }

        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if( rs != null ) rs.close();
                if( pstmt != null ) pstmt.close();
                if( con != null ) con.close();
            }catch(Exception e) {
                e.printStackTrace();
            }
        }

        return userDto;
    }
}
