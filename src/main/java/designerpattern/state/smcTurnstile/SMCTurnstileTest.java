package designerpattern.state.smcTurnstile;

import junit.framework.*;
import junit.textui.TestRunner;

/**
 * @author darkhaze
 */
public class SMCTurnstileTest extends TestCase {
    public static void main(String[] args) {
        TestRunner.main(new String[]{"SMCTurnstileTest"});
    }

    public SMCTurnstileTest(String name) {
        super(name);
    }

    private TurnstileFsm t;
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
            public void thankyou() {
                thankyouCalled = true;
            }

            @Override
            public void alarm() {
                alarmCalled = true;
            }
        };

        t = new TurnstileFsm(controllerSpoof);
    }

    public void testInitialConditions() {
        assertEquals("Locked", t.getCurrentStateName());
    }

    public void testCoinInLockedState() throws Exception {
        t.coin();
        assertEquals("Unlocked", t.getCurrentStateName());
        assert (unlockCalled);
    }

    public void testCoinInUnlockedState() throws Exception {
        t.coin(); // put in Unlocked state
        t.coin();
        assertEquals("Unlocked", t.getCurrentStateName());
        assert (thankyouCalled);
    }

    public void testPassInLockedState() throws Exception {
        t.pass();
        assertEquals("Locked", t.getCurrentStateName());
        assert (alarmCalled);
    }

    public void testPassInUnlockedState() throws Exception {
        t.coin(); // unlock
        t.pass();
        assertEquals("Locked", t.getCurrentStateName());
        assert (lockCalled);
    }
}
