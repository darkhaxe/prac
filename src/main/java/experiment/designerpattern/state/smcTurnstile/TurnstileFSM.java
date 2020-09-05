package experiment.designerpattern.state.smcTurnstile;

public class TurnstileFSM extends Turnstile {
    private TurnstileController controller;

    public TurnstileFSM(TurnstileController controller) {
        this.controller = controller;
    }

    @Override
    public void lock() {
        controller.lock();
    }

    @Override
    public void unlock() {
        controller.unlock();
    }

    @Override
    public void thankyou() {
        controller.thankyou();
    }

    @Override
    public void alarm() {
        controller.alarm();
    }
}
