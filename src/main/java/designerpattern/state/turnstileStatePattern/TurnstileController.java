package designerpattern.state.turnstileStatePattern;

/**
 * @author darkhaze
 */
public interface TurnstileController {
    void lock();

    void unlock();

    void thankYou();

    void alarm();
}
