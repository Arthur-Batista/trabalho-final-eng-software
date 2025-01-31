package sistemabiblioteca;

public interface IObservado {
    void adicionarObservador(IObservador observador);
    void removerObservador(IObservador observador);
    void notificarObservadores();
} 
