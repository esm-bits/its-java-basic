package esmbits.itsjavabasic.practices.member;

import java.util.ArrayList;
import java.util.List;

public class OutputMemberInfo {

    public static void main(String[] args) {
        List<Member> members = new ArrayList<>();
        members.add(new Member(12345, "hoge", 100));
        members.add(new Member(54321, "huge", 75));
        members.add(new VipMember(11111, "hogehoge", 100));
        members.add(new VipMember(22222, "hugahuga", 75));
        for (Member member: members) {
            System.out.println(member);
        }
    }
}
