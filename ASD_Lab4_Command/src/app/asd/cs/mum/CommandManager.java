package app.asd.cs.mum;

import iface.asd.cs.mum.Command;
import java.util.Vector;

public class CommandManager {
	Vector<Command> commandHistory;
	Vector<Command> undoHistory;
	Command command;
	
	public CommandManager(){
		this.commandHistory = new Vector<>();
		this.undoHistory = new Vector<>();
	}
	
	public void execute(Command newCommand){
		commandHistory.add(newCommand);
		newCommand.execute();  
	}
	
	public void undo(){
		if(commandHistory.size() > 0)
		{
			command = commandHistory.lastElement();
			command.undo();
			undoHistory.add(command);
			commandHistory.remove(command);
		}
	}
	
	public void redo(){
		if(undoHistory.size() > 0){
			command = undoHistory.lastElement();
			command.redo();
			undoHistory.remove(command);
			commandHistory.add(command);
		}
	}
}