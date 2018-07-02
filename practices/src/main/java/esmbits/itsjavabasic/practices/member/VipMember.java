package esmbits.itsjavabasic.practices.member;

public class VipMember extends Member{

    VipMember(int id, String name, double point) {
        super(id, name, point * 1.5);
    }

    @Override
    public String getName() {
        return super.getName() + " (VIP)";
    }

}
