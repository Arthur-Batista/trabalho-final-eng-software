package sistemabiblioteca;

public class AlunoGraduacao extends Usuario{

    public AlunoGraduacao(String usuarioId, String nome) {
        super(usuarioId, nome, 2, 4, new VerificarAluno());
    }
}
