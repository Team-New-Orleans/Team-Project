package states;

/**
 * Created by Simooo on 8.11.2015 ã..
 */
public class StateManager {
    private static State currentState = null;

    public static State getState() {
        return currentState;
    }

    public static void setState(State state) {
        currentState = state;
    }
}
