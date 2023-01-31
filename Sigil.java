import java.util.ArrayList;

interface SigilEffect {
    void applyEffect();
}

public class Sigil {
    public static void main(String[] args) throws Exception {
        ArrayList<SigilEffect> effects = new ArrayList<SigilEffect>();

        SigilEffect test = new SigilEffect() {
            String output = "test successful";
            public void applyEffect() {
                System.out.println(output);
            }
        };

        effects.add(test);

        effects.get(0).applyEffect();
    }
}
