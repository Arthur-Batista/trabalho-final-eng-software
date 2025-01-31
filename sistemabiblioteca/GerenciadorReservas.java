package sistemabiblioteca;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorReservas {
    private static GerenciadorReservas instancia;
    private List<Reserva> reservas;


    public GerenciadorReservas() {
        this.reservas = new ArrayList<>();
    }

    public static GerenciadorReservas getInstance() {
        if (instancia == null) {
            instancia = new GerenciadorReservas();
        }
        return instancia;
    }

    public void adicionarReserva(Reserva reserva) {
        reservas.add(reserva);
        if(procurarReservasPorLivro(reserva.getLivro()).size() > 2){
            reserva.getLivro().notificarObservadores();
            }
        }

    public void removerReserva(Reserva reserva) {
        reservas.remove(reserva);
    }

    public List<Reserva> getReservas() {
        return new ArrayList<>(reservas);
    }

    public List<Reserva> procurarReservasPorUsuario(Usuario usuario) {
        List<Reserva> resultado = new ArrayList<>();
        for (Reserva r : reservas) {
            if (r.getUsuario().equals(usuario)) {
                resultado.add(r);
            }
        }
        return resultado;
    }

    public List<Reserva> procurarReservasPorLivro(Livro livro) {
        List<Reserva> resultado = new ArrayList<>();
        for (Reserva r : reservas) {
            if (r.getLivro().equals(livro)) {
                resultado.add(r);
            }
        }
        return resultado;
    }

    public boolean existeReserva(Usuario usuario, Livro livro) {
        for (Reserva r : reservas) {
            if (r.getUsuario().equals(usuario) && r.getLivro().equals(livro)) {
                return true;
            }
        }
        return false;
    }

    public Reserva getReserva(Usuario usuario, Livro livro) {
        for (Reserva r : reservas) {
            if (r.getUsuario().equals(usuario) && r.getLivro().equals(livro)) {
                return r;
            }
        }
        return null;
    }
}


    