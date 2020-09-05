package designerpattern.state.smcTurnstile;//----------------------------------------------
//
// FSM:       Turnstile
// Context:   TurnstileActions
// Exception: FSMError
// Version:   
// Generated: Thursday 09/06/2001 at 12:23:59 CDT
//
//----------------------------------------------


//----------------------------------------------
//
// class Turnstile
//    This is the Finite State Machine class
//
public class Turnstile extends AbstractTurnstileActions {
    private State itsState;
    private static String itsVersion = "";

    // instance variables for each state
    private static Locked itsLockedState;
    private static Unlocked itsUnlockedState;

    // constructor
    public Turnstile() {
        itsLockedState = new Locked();
        itsUnlockedState = new Unlocked();

        itsState = itsLockedState;

        // Entry functions for: Locked
    }

    // accessor functions

    public String getVersion() {
        return itsVersion;
    }

    public String getCurrentStateName() {
        return itsState.stateName();
    }

    // event functions - forward to the current State

    public void pass() throws FsmException {
        itsState.pass();
    }

    public void coin() throws FsmException {
        itsState.coin();
    }

    //--------------------------------------------
    //
    // private class State
    //    This is the base State class
    //
    private abstract class State {
        public abstract String stateName();

        // default event functions

        public void pass() throws FsmException {
            throw new FsmException("pass", itsState.stateName());
        }

        public void coin() throws FsmException {
            throw new FsmException("coin", itsState.stateName());
        }

    }

    //--------------------------------------------
    //
    // class Locked
    //    handles the Locked State and its events
    //
    private class Locked extends State {
        @Override
        public String stateName() {
            return "Locked";
        }

        //
        // responds to coin event
        //
        @Override
        public void coin() {
            unlock();

            // change the state
            itsState = itsUnlockedState;
        }

        //
        // responds to pass event
        //
        @Override
        public void pass() {
            alarm();

            // change the state
            itsState = itsLockedState;
        }
    }

    //--------------------------------------------
    //
    // class Unlocked
    //    handles the Unlocked State and its events
    //
    private class Unlocked extends State {
        @Override
        public String stateName() {
            return "Unlocked";
        }

        //
        // responds to pass event
        //
        @Override
        public void pass() {
            lock();

            // change the state
            itsState = itsLockedState;
        }

        //
        // responds to coin event
        //
        @Override
        public void coin() {
            thankYou();

            // change the state
            itsState = itsUnlockedState;
        }
    }

}
