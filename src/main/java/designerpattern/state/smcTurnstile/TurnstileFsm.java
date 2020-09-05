package designerpattern.state.smcTurnstile;

import designerpattern.state.TurnstileController;

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
    public void thankYou() {
        controller.thankYou();
    }

    @Override
    public void alarm() {
        controller.alarm();
    }
}
