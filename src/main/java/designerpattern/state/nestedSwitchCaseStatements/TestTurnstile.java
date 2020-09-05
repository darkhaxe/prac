package designerpattern.state.nestedSwitchCaseStatements;

import designerpattern.state.TurnstileController;
import junit.framework.*;
import junit.textui.TestRunner;

/**
 * @author darkhaze
 */
public class TestTurnstile extends TestCase {
    public static void main(String[] args) {
        TestRunner.main(new String[]{"TestTurnstile"});
    }

    public TestTurnstile(String name) {
        super(name);
    }

    private Turnstile t;
    private boolean lockCalled = false;
    private boolean unlockCalled = false;
    private boolean thankyouCalled = false;
    private boolean alarmCalled = false;


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
            public void thankYou() {
                thankyouCalled = true;
            }

            @Override
            public void alarm() {
                alarmCalled = true;
            }
        };

        t = new Turnstile(controllerSpoof);
    }

    public void testInitialConditions() {
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
