package designerpattern.state.smcTurnstile;

/**
 * @author darkhaze
 */
public interface TurnstileController {
    void lock();

    void unlock();

    void thankyou();

    void alarm();
}