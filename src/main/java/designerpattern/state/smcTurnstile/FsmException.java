package designerpattern.state.smcTurnstile;

/**
 * @author darkhaze
 */
public class FsmException extends Exception {
    public FsmException(String event, String state) {
        super("Invalid event:" + event + " in state:" + state);
    }
}
