public class test {
    public static void main(String[] args) {
        member me = new member();
        String  s="woman";
        sex sex = Enum.valueOf(sex.class, s);
        me.setSe(sex);
        System.out.println(sex.getName());
    }

}
enum  sex{
    man("男"),woman("女");
    private  String  name;

    sex(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
class  member{
    private   sex   se=sex.man;

    public void setSe(sex se) {
        this.se = se;
    }
}