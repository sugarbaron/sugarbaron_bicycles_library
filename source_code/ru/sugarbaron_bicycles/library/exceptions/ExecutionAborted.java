/* author: sugarbaron ([sugarbaron_bicycles] e-mail:sugarbaron1@mail.ru)
   date: 12.09.2016 */
package ru.sugarbaron_bicycles.library.exceptions;

/**
 * this exception is for cases, when the final goal of method was
 * not reached because of different external conditions */
public final class ExecutionAborted
extends RuntimeException{
  private static final long serialVersionUID = 1L;
  
  public ExecutionAborted(String message){
    super(message);
    return;
  }
}