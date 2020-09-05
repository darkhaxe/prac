package designerpattern.state.turnstileStatePattern;

import designerpattern.state.TurnstileController;

/**
 * @author darkhaze
 */
public class Turnstile {
    private static TurnstileState lockedState = new LockedTurnstileState();
    private static TurnstileState unlockedState = new UnlockedTurnstileState();

    private TurnstileController turnstileController;
    private TurnstileState state = lockedState;

    public Turnstile(TurnstileController action) {
        turnstileController = action;
    }

    public void coin() {
        state.coin(this);
    }

    public void pass() {
        state.pass(this);
    }

    public void setLocked() {
        state = lockedState;
    }

    public void setUnlocked() {
        state = unlockedState;
    }

    public boolean isLocked() {
        return state == lockedState;
    }

    public boolean isUnlocked() {
        return state == unlockedState;
    }

    void thankyou() {
        turnstileController.thankYou();
    }

    void alarm() {
        turnstileController.alarm();
    }

    void lock() {
        turnstileController.lock();
    }

    void unlock() {
        turnstileController.unlock();
    }
}