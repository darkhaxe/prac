package experiment.designerpattern.state.TurnstileStatePattern;

import junit.framework.*;
import junit.textui.TestRunner;

public class TestStatePatternTurnstile extends TestCase {
    public static void main(String[] args) {
        TestRunner.main(new String[]{"TestStatePatternTurnstile"});
    }

    public TestStatePatternTurnstile(String name) {
        super(name);
    }

    private Turnstile t;
    private boolean lockCalled = false;
    private boolean unlockCalled = false;
    private boolean thankyouCalled = false;
    private boolean alarmCalled = false;


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
        assert (thankyouCalled);
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
