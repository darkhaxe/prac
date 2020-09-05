package designerpattern.state.stateTableTurnstile;

import designerpattern.state.TurnstileController;

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


    private static class Transition {
        public Transition(int currentState, int event, int newState, Runnable action) {
            this.currentState = currentState;
            this.event = event;
            this.newState = newState;
            this.action = action;
        }

        int currentState;
        int event;
        int newState;
        Runnable action;
    }

    public Turnstile(TurnstileController action) {
        controller = action;
        addTransition(LOCKED, COIN, UNLOCKED, unlock());
        addTransition(LOCKED, PASS, LOCKED, alarm());
        addTransition(UNLOCKED, COIN, UNLOCKED, thankyou());
        addTransition(UNLOCKED, PASS, LOCKED, lock());
    }

    private void addTransition(int currentState, int event, int newState, Runnable action) {
        transitions.add(new Transition(currentState, event, newState, action));
    }

    private Runnable lock() {
        return this::doLock;
    }

    private Runnable thankyou() {
        return this::doThankyou;
    }

    private Runnable alarm() {
        return this::doAlarm;
    }

    private Runnable unlock() {
        return this::doUnlock;
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
        controller.thankYou();
    }

    public void event(int event) {
        for (int i = 0; i < transitions.size(); i++) {
            Transition transition = transitions.elementAt(i);
            if (state == transition.currentState && event == transition.event) {
                state = transition.newState;
                transition.action.run();
            }
        }
    }

}