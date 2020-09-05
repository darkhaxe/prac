package experiment.designerpattern.state.smcTurnstile;

public class FSMError extends Exception {
    public FSMError(String event, String state) {
        super("Invalid event:" + event + " in state:" + state);
    }
}
