package ac.it.MVCTest.repository;



import ac.it.MVCTest.DTO.MemberDTO;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class MemberDAO {

    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/webserver";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public void insertMember(MemberDTO memberDTO) {
        try {
            Class.forName(JDBC_DRIVER);

            try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
                 PreparedStatement pstmt = conn.prepareStatement("INSERT INTO member (pwd,email,age) VALUES (?, ?, ?)")) {

                pstmt.setString(1, memberDTO.getPwd());
                pstmt.setString(2, memberDTO.getEmail());
                pstmt.setInt(3, Integer.parseInt(String.valueOf(memberDTO.getAge())));

                int rowsInserted = pstmt.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("A new member was inserted successfully!");
                }
            }

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void finduser(MemberDTO memberDTO) {

        MemberDTO member = new MemberDTO();
        try {
            Class.forName(JDBC_DRIVER);

            try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
                 PreparedStatement pstmt = conn.prepareStatement("select * from member where pwd=? and email=?")) {

                pstmt.setString(1, memberDTO.getPwd());
                pstmt.setString(2, memberDTO.getEmail());


                ResultSet rowsInserted = pstmt.executeQuery();
                System.out.println("welcome");
                if (rowsInserted.next()) {
                    member.setId(Integer.parseInt(rowsInserted.getString("id")));
                    member.setAge(Integer.parseInt(rowsInserted.getString("Age")));
                    member.setEmail(rowsInserted.getString("email"));
                    member.setPwd(rowsInserted.getString("pwd"));

                    System.out.println("this is a member");
                } else {
                    System.out.println("this is not member");
                    System.out.println("ok");

                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public List<MemberDTO> getAllMembers() {
        List<MemberDTO> members = new ArrayList<>();

        try {
            Class.forName(JDBC_DRIVER);

            try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
                 PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM member");
                 ResultSet rs = pstmt.executeQuery()) {

                while (rs.next()) {
                    MemberDTO member = new MemberDTO();
                    member.setEmail(rs.getString("email"));
                    member.setPwd(rs.getString("pwd"));
                    member.setAge(rs.getInt("age"));

                    members.add(member);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return members;
    }

    public MemberDTO findById(int id) {
        MemberDTO member = new MemberDTO();
        try {
            Class.forName(JDBC_DRIVER);

            try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
                 PreparedStatement pstmt = conn.prepareStatement("select * from member where id = ?")) {

                pstmt.setInt(1, id);


                ResultSet rowsInserted = pstmt.executeQuery();
                System.out.println("welcome");
                if (rowsInserted.next()) {
                    member.setId(Integer.parseInt(rowsInserted.getString("id")));
                    member.setAge(Integer.parseInt(rowsInserted.getString("Age")));
                    member.setEmail(rowsInserted.getString("email"));
                    member.setPwd(rowsInserted.getString("pwd"));

                    System.out.println("this is a member");
                } else {
                    System.out.println("this is not member");
                    System.out.println("ok");

                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        return member;
    }
}
