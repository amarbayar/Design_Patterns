package impl.asd.cs.mum;

import model.asd.cs.mum.VStack;
import iface.asd.cs.mum.Command;

public class PushStack implements Command {

	private VStack vStack;
	
	public PushStack(VStack vStack){
		this.vStack = vStack;
	}
	
	@Override
	public void execute() {
		vStack.push(vStack.getPushString());
	}
	
	@Override
	public void undo(){
		vStack.pop();
	}
	
	@Override
	public void redo(){
		vStack.push(vStack.getRedoElement());
	}
}
