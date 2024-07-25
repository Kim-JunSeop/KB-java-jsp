package org.example;

public class Run {

    public static void main(String[] args) {
        MemberDAO dao = new MemberDAO();
        Member member = dao.selectOne(1);
        System.out.println(member);
    }
}
