import java.util.Stack;

enum Views {
    START("path_1"),
    OPTIONS("path_2"),
    LOADING("path_3"),
    CONFIRM("path_4"),
    GAME("path_5");

    private String path;

    private Views(String p) {
        this.path = p;
    }

    public String getPath() {
        return this.path;
    }
}

public class App {

    private static String view = Views.START.getPath();
    private static Stack<Views> view_history = new Stack<Views>();
    private static Session session = new Session();

    public static void renderView(Views v) {
        view = v.getPath();
        view_history.push(v);
    }
    
    public static void returnView() {
        view = view_history.pop().getPath();
    }

    public static void startGame() {
        session.setActivity(true);
        session.render();
        session.nextPhase();
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello World!");
    }
}
