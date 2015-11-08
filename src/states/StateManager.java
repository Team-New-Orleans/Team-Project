package states;

/**
 * Created by Simooo on 8.11.2015 ã..
 */
public class StateManager {
    private State currentState;

    public State getState() {
        return currentState;
    }

    public void setState(State currentState) {
        this.currentState = currentState;
    }
}
