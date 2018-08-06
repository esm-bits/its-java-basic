package esmbits.itsjavabasic.practices.member;

public class VipMember extends Member {

    public VipMember(int id, String name, double point) {
        super(id, name + " (VIP)", point * 1.5);
    }
}
