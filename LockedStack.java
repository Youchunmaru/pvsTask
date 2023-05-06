import java.io.ObjectStreamClass;

public class LockedStack<T> implements Stack<T> {

  private boolean locked;
  private final Stack<T> stack;

  public LockedStack(Stack<T> stack){
    locked = false;
    this.stack = stack;
  }

  public void lock(){
    locked = true;
  }

  public void open(){
    locked = false;
  }

  @Override
  public void push(T element) {
    if (locked){
      throw new StackLockedException();
    }
    stack.push(element);
  }

  @Override
  public T pop() {
    if (locked){
      throw new StackLockedException();
    }
    return stack.pop();
  }
}

interface Stack<T>{
  public void push(T element);
  public T pop();
}

class StackLockedException extends RuntimeException{}