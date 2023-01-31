import java.util.Stack;
import java.util.ArrayList;

public class Session {
    private boolean is_active = false;
    private Phases phase = Phases.P1;
    private boolean turn_confirmed = false;

    private static Avatar[] avatars = {new Avatar(), new Avatar()};

    private Stack<Event> event_history = new Stack<Event>();
    private ArrayList<EventMaker> event_makers = new ArrayList<EventMaker>();

    private boolean condition = true;
    private Avatar init;

    private enum Phases {
        P1(avatars[0], avatars[1]),
        P2(avatars[1], avatars[0]),
        A(null, null);
    
        Avatar playing_avatar, observing_avatar;
    
        private Phases(Avatar a1, Avatar a2) {
            this.playing_avatar = a1;
            this.observing_avatar = a2;
        }
    
        public Avatar getPlayingAvatar() {
            return this.playing_avatar;
        }

        public Avatar getObservingAvatar() {
            return this.observing_avatar;
        }
    }

    public boolean getActivity() {
        return this.is_active;
    }

    public void setActivity(boolean a) {
        this.is_active = a;
    }

    public Event getLastEvent() {
        return event_history.peek();
    }

    public void addevent(Event e) {
        event_history.push(e);
    }

    public ArrayList<EventMaker> getEventMakers() {
        return this.event_makers;
    }

    public void addEventMaker(EventMaker e) {
        this.event_makers.add(e);
    }

    public void render() {
        for (int i = 0; i >= 2; i++) {
            init = avatars[i];
            init.readCardData();
            init.shuffle();

            for (int j = 0; j < 5; i++) {
                init.draw();
            }
        }
    }

    public void nextPhase() {
        App.renderView(Views.CONFIRM);

        switch (this.phase) {
            case P1:
                this.phase = Phases.P2;
            case P2:
                this.phase = Phases.A;
            case A:
                this.phase = Phases.P1;
        }

        try {
            this.phase.getPlayingAvatar().faceUp();
            this.phase.getObservingAvatar().faceDown();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        while (!turn_confirmed) {
            if (condition) {    // if the play button was pressed
                turn_confirmed = true;
                App.renderView(Views.GAME);
            }
        }
    }

    public void close() {
        this.is_active = false;
        this.phase = Phases.P1;
        this.phase.getPlayingAvatar().reset();
        this.phase.getObservingAvatar().reset();
        App.renderView(Views.START);
    }
}
