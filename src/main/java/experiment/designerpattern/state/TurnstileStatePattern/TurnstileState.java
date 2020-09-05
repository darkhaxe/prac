package experiment.designerpattern.state.TurnstileStatePattern;

interface TurnstileState {
    void coin(Turnstile t);

    void pass(Turnstile t);
}

class LockedTurnstileState implements TurnstileState {
    @Override
    public void coin(Turnstile t) {
        t.setUnlocked();
        t.unlock();
    }

    @Override
    public void pass(Turnstile t) {
        t.alarm();
    }
}

class UnlockedTurnstileState implements TurnstileState {
    @Override
    public void coin(Turnstile t) {
        t.thankyou();
    }

    @Override
    public void pass(Turnstile t) {
        t.setLocked();
        t.lock();
    }
}