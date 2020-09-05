package experiment.designerpattern.state.TurnstileStatePattern;

public class Turnstile {
    private static TurnstileState lockedState = new LockedTurnstileState();
    private static TurnstileState unlockedState = new UnlockedTurnstileState();

    private TurnstileController TurnstileController;
    private TurnstileState state = lockedState;

    public Turnstile(TurnstileController action) {
        TurnstileController = action;
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
        TurnstileController.thankyou();
    }

    void alarm() {
        TurnstileController.alarm();
    }

    void lock() {
        TurnstileController.lock();
    }

    void unlock() {
        TurnstileController.unlock();
    }
}
