package memento;

import java.util.ArrayList;
import java.util.Stack;

public class Caretaker {

    //SI OCCUPA DI CREARE UNA PILA DEI SALVATAGGI

    public Stack<Memento> saveState = new Stack<Memento>();

    public void addMemento(Memento m){
        saveState.push(m);
    }
     public Memento popMemento(){
        if (saveState.size() != 1)
                saveState.pop();

        return saveState.peek();
     }




}
