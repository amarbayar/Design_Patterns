package model.asd.cs.mum;

import java.util.*;

public class VStack{
   private Vector stackvector;  
   private Vector popHistory;
   private String pushString;
   
   public VStack(){
      stackvector = new Vector();
      popHistory = new Vector();
      pushString = "";
   }
   
   public void push(Object obj){
      stackvector.insertElementAt(obj,0);
   }
   
   public Object pop(){
      if (stackvector.size()>0){
         Object obj =stackvector.firstElement();
         stackvector.removeElementAt(0);
         popHistory.add(obj);
         return obj;
      }
      else
         return null;
   }
   
   public int getSize(){
      return stackvector.size();
   }
   
   public Vector getStackVector(){
      return stackvector;
   }
   
   public void setPushString(String newPushString){
	   pushString = newPushString;
   }
   
   public String getPushString(){
	   return pushString;
   }
   
   public String getRedoElement(){
	   if(popHistory.size() > 0){
		   String redoEl = popHistory.lastElement().toString();
		   popHistory.remove(redoEl);
		   return redoEl;
	   }
	   return null;
   }
   
   public void clear(){
	   popHistory.clear();
	   int index = 0;
	   for(int i = stackvector.size() - 1; i >= 0; i--){
		   popHistory.insertElementAt(stackvector.get(i), index);
		   index++;
	   }
	   stackvector.clear();
   }
   
   public void restore(){
	   for(Object o: popHistory){
		   push(o);
	   }
	   popHistory.clear();
   }
}

