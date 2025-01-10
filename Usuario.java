public abstract class Usuario {
    private int usuarioId;
    private String nome;
    private int tempoEmprestimo;

    public Usuario(int usuarioId, String nome, int tempoEmprestimo) {
        this.usuarioId = usuarioId;
        this.nome = nome;
        this.tempoEmprestimo = tempoEmprestimo;
    }
}
