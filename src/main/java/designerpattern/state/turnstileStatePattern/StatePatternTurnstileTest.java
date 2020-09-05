package designerpattern.state.turnstileStatePattern;

import junit.framework.TestCase;
import junit.textui.TestRunner;

/**
 * @author darkhaze
 */
public class StatePatternTurnstileTest extends TestCase {
    public static void main(String[] args) {
        TestRunner.main(new String[]{"TestStatePatternTurnstile"});
    }

    public StatePatternTurnstileTest(String name) {
        super(name);
    }

    private Turnstile t;
    private boolean lockCalled = false;
    private boolean unlockCalled = false;
    private boolean thankYouCalled = false;
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
                thankYouCalled = true;
            }

            @Override
            public void alarm() {
                alarmCalled = true;
            }
        };

        t = new Turnstile(controllerSpoof);
    }

    public void testInitialConditions() {
        assert (t.isLocked());
    }

    public void testCoinInLockedState() {
        t.setLocked();
        t.coin();
        assert (t.isUnlocked());
        assert (unlockCalled);
    }

    public void testCoinInUnlockedState() {
        t.setUnlocked();
        t.coin();
        assert (t.isUnlocked());
        assert (thankYouCalled);
    }

    public void testPassInLockedState() {
        t.setLocked();
        t.pass();
        assert (t.isLocked());
        assert (alarmCalled);
    }

    public void testPassInUnlockedState() {
        t.setUnlocked();
        t.pass();
        assert (t.isLocked());
        assert (lockCalled);
    }
}
