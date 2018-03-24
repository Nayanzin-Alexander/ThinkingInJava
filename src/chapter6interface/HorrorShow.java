package chapter6interface;

/**
 * Created by nayanzin on 28.06.17.
 */
public class HorrorShow {
    static void u(Monster b){b.menace();}
    static void v(DangerousMonster d) {
        d.menace();
        d.destroy();
    }
    static void w(Lethal v){v.kill();}

    public static void main(String... args){
        DangerousMonster barney = new DragonZilla();
        u(barney);
        v(barney);
        Vampire vlad = new VeryBadVampire();
        u(vlad);
        v(vlad);
        w(vlad);
    }
}
