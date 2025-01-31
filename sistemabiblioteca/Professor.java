package sistemabiblioteca;

public class Professor extends Usuario implements IObservador{

    public Professor(String usuarioId, String nome) {
        super(usuarioId, nome, 8, new VerificarProfessor());
    }

    @Override
    public void atualizar() {
        super.incrementarContadorNotificacoes();
    }
}
