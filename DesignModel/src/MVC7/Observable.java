package MVC7;



public interface Observable {
     public void notifyObservers();
     public void register(Observer obs);
}