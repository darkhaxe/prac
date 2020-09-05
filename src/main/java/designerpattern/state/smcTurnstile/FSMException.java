package designerpattern.state.smcTurnstile;

/**
 * @author darkhaze
 */
public class FSMException extends Exception {
    public FSMException(String event, String state) {
        super("Invalid event:" + event + " in state:" + state);
    }
}
