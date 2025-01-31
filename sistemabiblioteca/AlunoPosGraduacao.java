package sistemabiblioteca;

public class AlunoPosGraduacao extends Usuario{

    public AlunoPosGraduacao(String usuarioId, String nome) {
        super(usuarioId, nome, 3, 5, new VerificarAluno());
    }
}
