package experiment.designerpattern.state.nestedSwitchCaseStatements;

public class Turnstile {
    // States
    public static final int LOCKED = 0;
    public static final int UNLOCKED = 1;

    // Events
    public static final int COIN = 0;
    public static final int PASS = 1;

    /*private*/ int state = LOCKED;

    private TurnstileController TurnstileController;

    public Turnstile(TurnstileController action) {
        TurnstileController = action;
    }

    public void event(int event) {
        switch (state) {
            case LOCKED:
                switch (event) {
                    case COIN:
                        state = UNLOCKED;
                        TurnstileController.unlock();
                        break;
                    case PASS:
                        TurnstileController.alarm();
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + event);
                }
                break;
            case UNLOCKED:
                switch (event) {
                    case COIN:
                        TurnstileController.thankyou();
                        break;
                    case PASS:
                        state = LOCKED;
                        TurnstileController.lock();
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + event);
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + state);
        }
    }
}
