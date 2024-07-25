package org.example;

import java.sql.*;
import java.util.Date;
import java.util.List;


public class MemberDAO {
    public static String driverClass = "com.mysql.cj.jdbc.Driver";
    public static String url = "jdbc:mysql://localhost:3306/jdbc";
    public static String user = "user";
    public static String password = "1234";
    private Connection conn = null;

    public MemberDAO() {
        try {
            Class.forName(driverClass);
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public Member selectOne(int no) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select * from member where mno = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, no);
            rs = ps.executeQuery();
            if (rs.next()) {
                int mno = rs.getInt("mno");
                String id = rs.getString("id");
                String password = rs.getString("password");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                int age = rs.getInt("age");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                String hobby = rs.getString("hobby");
                Date birthday = rs.getDate("birthday");
                Date enrolldate = rs.getDate("enrolldate");
                return new Member(mno, id, password, name, gender, age, email, phone, address, hobby, birthday, enrolldate);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return null;
    }

    public List<Member> selectAll(String id, String name) {

        return null;
    }

    public int insert(Member m) {

        return 0;
    }
}
