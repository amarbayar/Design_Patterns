package impl.asd.cs.mum;

import model.asd.cs.mum.VStack;
import iface.asd.cs.mum.Command;

public class ClearStack implements Command{

	private VStack vStack;

	public ClearStack(VStack vStack){
		this.vStack = vStack;
	}
	public void execute() {
		vStack.clear();
	}

	public void undo() {
		vStack.restore();
	}

	public void redo() {
		vStack.clear();
	}
	

}
