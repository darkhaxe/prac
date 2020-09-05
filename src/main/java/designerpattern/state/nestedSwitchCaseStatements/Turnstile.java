package designerpattern.state.nestedSwitchCaseStatements;

import designerpattern.state.TurnstileController;

public class Turnstile {
    // States
    public static final int LOCKED = 0;
    public static final int UNLOCKED = 1;

    // Events
    public static final int COIN = 0;
    public static final int PASS = 1;

    /*private*/ int state = LOCKED;

    private TurnstileController turnstileController;

    public Turnstile(TurnstileController action) {
        turnstileController = action;
    }

    public void event(int event) {
        switch (state) {
            case LOCKED:
                switch (event) {
                    /*
                      投币
                     */
                    case COIN:
                        state = UNLOCKED;
                        turnstileController.unlock();
                        break;
                    /*
                    通过
                     */
                    case PASS:
                        turnstileController.alarm();
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + event);
                }
                break;
            case UNLOCKED:
                switch (event) {
                    case COIN:
                        turnstileController.thankYou();
                        break;
                    case PASS:
                        state = LOCKED;
                        turnstileController.lock();
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
