/* author: sugarbaron ([sugarbaron_bicycles] e-mail:sugarbaron1@mail.ru)
   date: 03.09.2016 */
package ru.sugarbaron_bicycles.library.state_machine.automatic_state_machine;

import ru.sugarbaron_bicycles.library.state_machine.*;

import java.util.List;

final class Action1State
extends StateMachineState{
  private List<StateMachineState> statesRecorder;
  private List<StateHandlers> handlersRecorder;
  private boolean isJustEntered;

  Action1State(StateMachine machine, List<StateMachineState> statesRecorder, List<StateHandlers> handlersRecorder){
    super(machine);
    this.statesRecorder = statesRecorder;
    this.handlersRecorder = handlersRecorder;
    this.isJustEntered = true;
    return;
  }

  @Override
  protected void enter()
  throws Exception{
    handlersRecorder.add(StateHandlers.ACTION_1_ENTER);
    isJustEntered = true;
    return;
  }

  @Override
  protected void activity()
  throws Exception{
    handlersRecorder.add(StateHandlers.ACTION_1_ACTIVITY);
    StateMachineState currentState = stateMachine.getCurrentState();
    statesRecorder.add(currentState);

    StateMachineSignal controlSignal = defineControlSignal();
    isJustEntered = false;

    stateMachine.setNextStepSignal(controlSignal);
    stateMachine.makeStep();
    return;
  }

  private StateMachineSignal defineControlSignal(){
    StateMachineSignal controlSignal;
    if(isJustEntered){
      controlSignal = stateMachine.getSignalByName(SignalsNames.REPEAT);
    }
    else{
      controlSignal = stateMachine.getSignalByName(SignalsNames.START_ACTION_2);
    }
    return controlSignal;
  }

  @Override
  protected void leave()
  throws Exception{
    handlersRecorder.add(StateHandlers.ACTION_1_LEAVE);
    return;
  }
}