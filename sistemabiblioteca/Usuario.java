package sistemabiblioteca;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public abstract class Usuario {
    private String usuarioId;
    private String nome;
    private int limiteEmprestimo;
    private int tempoEmprestimo;
    private IVerificarEmprestimoStrategy verificarEmprestimo;

    private List<Emprestimo> emprestimosPassados = new ArrayList<>();

    public Usuario(String usuarioId, String nome, int limiteEmprestimo, int tempoEmprestimo, IVerificarEmprestimoStrategy verificarEmprestimo){
        this.usuarioId = usuarioId;
        this.nome = nome;
        this.limiteEmprestimo = limiteEmprestimo;
        this.tempoEmprestimo= tempoEmprestimo;
        this.verificarEmprestimo = verificarEmprestimo;
        this.emprestimosPassados = new ArrayList<>();
    }

    public Usuario(String usuarioId, String nome, int tempoEmprestimo,  IVerificarEmprestimoStrategy verificarEmprestimo){
        this.usuarioId = usuarioId;
        this.nome = nome;
        this.limiteEmprestimo = 0;
        this.tempoEmprestimo = tempoEmprestimo;
        this.verificarEmprestimo = verificarEmprestimo;
        this.emprestimosPassados = new ArrayList<>();
    }

    public void adicionarEmprestimosPassados(Emprestimo emprestimo) {
        emprestimosPassados.add(emprestimo);
    }

    public List<Emprestimo> listarEmprestimosPassados() {
        return new ArrayList<>(emprestimosPassados);
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getLimiteEmprestimo() {
        return limiteEmprestimo;
    }

    public void setLimiteEmprestimo(int limiteEmprestimo) {
        this.limiteEmprestimo = limiteEmprestimo;
    }

    public int getTempoEmprestimo() {
        return tempoEmprestimo;
    }

    public void setTempoEmprestimo(int tempoEmprestimo) {
        this.tempoEmprestimo = tempoEmprestimo;
    }

    public boolean obterVerificacao(Usuario usuario, Livro livro){
        return verificarEmprestimo.podeEmprestar(usuario, livro);
    }

    public boolean isDevedor() {
        LocalDate hoje = LocalDate.now();
        for (Emprestimo emprestimo : GerenciadorEmprestimos.getInstance().procurarEmprestimosPorUsuario(this)) {
            if (hoje.isAfter(emprestimo.getDataDevolucao())) {
                return true; 
            }
        }
        return false;
    }

    public IObservador getObservador() {
        return null;
    }

}

