package sistemabiblioteca;

public class Professor extends Usuario implements IObservador{
    private int contadorNotificacoes;

    public Professor(int usuarioId, String nome) {
        super(usuarioId, nome, 8, new VerificarProfessor());
        this.contadorNotificacoes = 0;
    }

    @Override
    public void atualizar() {
        contadorNotificacoes++;
    }

    public int getContadorNotificacoes() {
        return contadorNotificacoes;
    }

}
