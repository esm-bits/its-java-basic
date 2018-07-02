package esmbits.itsjavabasic.practices.member;

public class Member {

    // 会員クラス(Member)、VIP会員クラス(VipMember)、会員情報を出力するクラス(OutputMemberInfo)を作る。

    // 会員クラスはプロパティにIDと名前、ポイントを持つ。
    // VIP会員クラスは会員クラスを継承し、プロパティの名前を取得する際には語尾に" (VIP)"を付け加え、ポイントを設定する際にポイントを1.5倍に割り増しにする。
    // 会員情報を出力するクラスはコンソールに下記のようにログを出力する。
        /*実行結果
         * ID:12345, Name:hoge, Point:100.0
         * ID:54321, Name:huge, Point:75.0
         * ID:11111, Name:hogehoge (VIP), Point:150.0
         * ID:22222, Name:hugahuga (VIP), Point:112.5
         */

    // 会員クラスでObject.toString()をオーバライドして、出力するログを作成し返すようにしてください。

    private int id;
    private String name;
    private double point;

    Member(int id, String name, double point) {
        this.id = id;
        this.name = name;
        this.point = point;
    }

    private int getId() {
        return this.id;
    }

    protected String getName() {
        return this.name;
    }

    private double getPoint() {
        return this.point;
    }

    @Override
    public String toString() {
        return "ID:" + getId() + ", Name:" + getName() + ", Point:" + getPoint();
    }
}
