import java.util.ArrayList;
import java.util.List;

public class GerenciadorEmprestimos {
    private List<Emprestimo> emprestimos;

    public GerenciadorEmprestimos() {
        this.emprestimos = new ArrayList<>();
    }

    public void adicionarEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    public void removerEmprestimo(Emprestimo emprestimo) {
        emprestimos.remove(emprestimo);
    }

    public List<Emprestimo> getEmprestimos() {
        return new ArrayList<>(emprestimos);
    }

    public boolean verificarEmprestimo(String usuarioId, String livroId) {
        for (Emprestimo e : emprestimos) {
            if (e.getUsuarioId().equals(usuarioId) && e.getLivroId().equals(livroId)) {
                return true;
            }
        }
        return false;
    }

    public List<Emprestimo> procurarEmprestimosPorUsuario(Usuario usuario) {
        List<Emprestimo> resultado = new ArrayList<>();
        for (Emprestimo e : emprestimos) {
            if (e.getUsuario().equals(usuario)) {
                resultado.add(e);
            }
        }
        return resultado;
    }

    public List<Emprestimo> procurarEmprestimosPorLivro(Livro livro) {
        List<Emprestimo> resultado = new ArrayList<>();
        for (Emprestimo e : emprestimos) {
            if (e.getLivro().equals(livro)) {
                resultado.add(e);
            }
        }
        return resultado;
    }

    public Emprestimo getEmprestimo(Usuario usuario, Livro livro) {
        for (Emprestimo e : emprestimos) {
            if (e.getUsuario().equals(usuario) && e.getLivro().equals(livro)) {
                return e;
            }
        }
        return null;
    }
}