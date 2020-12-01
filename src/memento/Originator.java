package memento;

import view.Punto;

import java.util.ArrayList;

public class Originator {

    //L'ORIGINATOR TIENE CONTO DELLO STATO CORRENTE
    private ArrayList<Punto> state = new ArrayList<Punto>();

    //SETTA LO STATO DI FUORI CON QUELLO DI DENTRO
    public void setOriginatorState(ArrayList<Punto> p){
        state.clear();
        for (int i = 0; i < p.size(); i++) {
            state.add(p.get(i));
        }

    }

    public ArrayList<Punto> getOriginatorState(){
        return state;
    }

    //RIPRISTINA LO STATO PRECEDENTE SALVATO DAL MEMENTO
    public void restore (Memento m){
        state.clear();
        for (int i = 0; i < m.getState().size(); i++) {
            state.add(m.getState().get(i));
        }
    }

    //CREA UN NUOVO MEMENTO CON LO STATO ATTUALE
    public Memento createMemento(){
        Memento memento = new Memento();
        memento.setMementoState(state);
        return memento;
    }
}
