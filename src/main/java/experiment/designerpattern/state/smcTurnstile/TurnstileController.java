package experiment.designerpattern.state.smcTurnstile;

public interface TurnstileController {
    public void lock();

    public void unlock();

    public void thankyou();

    public void alarm();
}