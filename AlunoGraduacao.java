package sistemabiblioteca;

public class AlunoGraduacao extends Usuario{
    public AlunoGraduacao(int usuarioId, String nome) {
        super(usuarioId, nome, 2, 4, new VerificarAluno());
    }
}
