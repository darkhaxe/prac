package designerpattern.state.stateTableTurnstile;

import java.util.Vector;

/**
 * @author darkhaze
 */
public class Turnstile {
    /**
     * States
     */
    public static final int LOCKED = 0;
    public static final int UNLOCKED = 1;

    /**
     * Events
     */
    public static final int COIN = 0;
    public static final int PASS = 1;

    /**
     * private
     */
    int state = LOCKED;
    private TurnstileController controller;
    private Vector<Transition> transitions = new Vector<>();

    private interface Action {
        void execute();
    }

    private static class Transition {
        public Transition(int currentState, int event, int newState, Action action) {
            this.currentState = currentState;
            this.event = event;
            this.newState = newState;
            this.action = action;
        }

        int currentState;
        int event;
        int newState;
        Action action;
    }

    public Turnstile(TurnstileController action) {
        controller = action;
        addTransition(LOCKED, COIN, UNLOCKED, unlock());
        addTransition(LOCKED, PASS, LOCKED, alarm());
        addTransition(UNLOCKED, COIN, UNLOCKED, thankyou());
        addTransition(UNLOCKED, PASS, LOCKED, lock());
    }

    private void addTransition(int currentState, int event, int newState, Action action) {
        transitions.add(new Transition(currentState, event, newState, action));
    }

    private Action lock() {
        return new Action() {
            @Override
            public void execute() {
                doLock();
            }
        };
    }

    private Action thankyou() {
        return new Action() {
            @Override
            public void execute() {
                doThankyou();
            }
        };
    }

    private Action alarm() {
        return new Action() {
            @Override
            public void execute() {
                doAlarm();
            }
        };
    }

    private Action unlock() {
        return new Action() {
            @Override
            public void execute() {
                doUnlock();
            }
        };
    }

    private void doUnlock() {
        controller.unlock();
    }

    private void doLock() {
        controller.lock();
    }

    private void doAlarm() {
        controller.alarm();
    }

    private void doThankyou() {
        controller.thankyou();
    }

    public void event(int event) {
        for (int i = 0; i < transitions.size(); i++) {
            Transition transition = (Transition) transitions.elementAt(i);
            if (state == transition.currentState && event == transition.event) {
                state = transition.newState;
                transition.action.execute();
            }
        }
    }

}