package designerpattern.state.stateTableTurnstile;

import junit.framework.TestCase;
import junit.textui.TestRunner;

/**
 * @author darkhaze
 */
public class TestStateTableTurnstile extends TestCase {
    public static void main(String[] args) {
        TestRunner.main(new String[]{"TestStateTableTurnstile"});
    }

    public TestStateTableTurnstile(String name) {
        super(name);
    }

    private boolean lockCalled = false;
    private boolean unlockCalled = false;
    private boolean thankyouCalled = false;
    private boolean alarmCalled = false;

    private Turnstile t = null;

    @Override
    public void setUp() {
        TurnstileController controllerSpoof = new TurnstileController() {
            @Override
            public void lock() {
                lockCalled = true;
            }

            @Override
            public void unlock() {
                unlockCalled = true;
            }

            @Override
            public void thankyou() {
                thankyouCalled = true;
            }

            @Override
            public void alarm() {
                alarmCalled = true;
            }
        };

        t = new Turnstile(controllerSpoof);
    }

    public void testCoin() throws Exception {
        assertEquals(Turnstile.LOCKED, t.state);
    }

    public void testCoinInLockedState() {
        t.state = Turnstile.LOCKED;
        t.event(Turnstile.COIN);
        assertEquals(Turnstile.UNLOCKED, t.state);
        assert (unlockCalled);
    }

    public void testCoinInUnlockedState() {
        t.state = Turnstile.UNLOCKED;
        t.event(Turnstile.COIN);
        assertEquals(Turnstile.UNLOCKED, t.state);
        assert (thankyouCalled);
    }

    public void testPassInLockedState() {
        t.state = Turnstile.LOCKED;
        t.event(Turnstile.PASS);
        assertEquals(Turnstile.LOCKED, t.state);
        assert (alarmCalled);
    }

    public void testPassInUnlockedState() {
        t.state = Turnstile.UNLOCKED;
        t.event(Turnstile.PASS);
        assertEquals(Turnstile.LOCKED, t.state);
        assert (lockCalled);
    }
}