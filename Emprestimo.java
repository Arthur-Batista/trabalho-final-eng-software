public class Emprestimo {
    private Usuario usuario;
    private Exemplar exemplar;
    private Date dataEmprestimo;
    private Date dataDevolucao;
    private boolean isFinalizado;
    private Date foiDevolvido;

    public Emprestimo(Usuario usuario, Exemplar exemplar) {
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucao = calcularDataDevolucao();
        this.usuario = usuario;
        this.exemplar = exemplar;
        this.foiDevolvido = null;
        this.isFinalizado = false;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    private LocalDate calcularDataDevolucao() {
        int diasEmprestimo = usuario.getTempoEmprestimo();
        return dataEmprestimo.plusDays(diasEmprestimo);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    public boolean isFinalizado() {
        return status;
    }

    public void setStatus(boolean isFinalizado) {
        this.isFinalizado = isFinalizado;
    }

    public void setFoiDevolvido(Date foiDevolvido) {
        this.foiDevolvido = foiDevolvido;
    }

}