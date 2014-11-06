package impl.asd.cs.mum;

import model.asd.cs.mum.VStack;
import iface.asd.cs.mum.Command;

public class PopStack implements Command {

	private VStack vStack;
	
	public PopStack(VStack vStack){
		this.vStack = vStack;
	}
	
	@Override
	public void execute() {
		vStack.pop();
	}
	
	@Override
	public void undo(){
		vStack.push(vStack.getRedoElement());
	}
	
	@Override
	public void redo(){
		vStack.push(vStack.getRedoElement());
	}
}
