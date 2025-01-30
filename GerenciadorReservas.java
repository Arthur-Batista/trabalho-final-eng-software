import java.util.ArrayList;
import java.util.List;

public class GerenciadorReservas {
    private List<Reserva> reservas;

    public GerenciadorReservas() {
        this.reservas = new ArrayList<>();
    }

    public void adicionarReserva(Reserva reserva) {
        reservas.add(reserva);
        if(procurarReservasPorLivro(reserva.getLivro().size()) > 2){
            reserva.getLivro().notificarObservadores();
            }
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

    public Reserva getReserva(String usuarioId, String livroId) {
        for (Reserva r : reservas) {
            if (r.getUsuarioId().equals(usuarioId) && r.getLivroId().equals(livroId)) {
                return r;
            }
        }
        return null;
    }

    
}