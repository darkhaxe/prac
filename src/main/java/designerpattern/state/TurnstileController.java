package designerpattern.state;

/**
 * @author darkhaze
 */
public interface TurnstileController {
    /**
     * 锁定
     */
    void lock();

    /**
     * 解锁
     */
    void unlock();

    /**
     * 提示不需要投币
     */
    void thankYou();

    /**
     * 警报
     */
    void alarm();
}