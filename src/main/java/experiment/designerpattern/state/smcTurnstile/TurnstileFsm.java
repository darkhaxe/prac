package experiment.designerpattern.state.smcTurnstile;

/**
 * @author darkhaze
 */
public class TurnstileFsm extends Turnstile {
    private TurnstileController controller;

    public TurnstileFsm(TurnstileController controller) {
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
