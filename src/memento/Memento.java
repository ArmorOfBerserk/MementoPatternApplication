package memento;

import view.Punto;

import java.util.ArrayList;

public class Memento {

    private ArrayList<Punto> stateMemento = new ArrayList<Punto>();

    //SI RITORNA L'ELEMENTO
    public ArrayList<Punto> getState(){
        return this.stateMemento;
    }


    public void setMementoState(ArrayList<Punto> memento) {
        stateMemento.clear();
        for (int i = 0; i < memento.size(); i++) {
            stateMemento.add(memento.get(i));
        }
    }
}
