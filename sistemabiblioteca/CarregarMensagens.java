package sistemabiblioteca;

public class CarregarMensagens {
    

    public static void imprimirDetalhesLivro(Livro livro) {
        System.out.println("Título: " + livro.getTitulo());
        System.out.println("Quantidade de reservas: " + GerenciadorReservas.getInstance().procurarReservasPorLivro(livro).size());
    }

    public static void imprimirReservas(Livro livro) {
        if (GerenciadorReservas.getInstance().procurarReservasPorLivro(livro).size() > 0) {
            System.out.println("Usuários que realizaram reservas:");
            for (Reserva reserva : GerenciadorReservas.getInstance().procurarReservasPorLivro(livro)) {
                System.out.println(" - " + reserva.getUsuario().getNome());
            }
        }
    }

    public static void imprimirExemplares(Livro livro) {
        System.out.println("Exemplares:");
        for (Exemplar exemplar : livro.listarExemplares()) {
            System.out.println("Código: " + exemplar.getId());
            System.out.println("Status: " + (exemplar.isDisponivel() ? "Disponível" : "Emprestado"));

            if (!exemplar.isDisponivel()) {
                Emprestimo emprestimo = exemplar.getEmprestimo();
                System.out.println("Usuário: " + emprestimo.getUsuario().getNome());
                System.out.println("Data de empréstimo: " + emprestimo.getDataEmprestimo());
                System.out.println("Data prevista para devolução: " + emprestimo.getDataDevolucao());
            }
        }
    }

    public static void imprimirNotificacoes(Usuario usuario) {
        System.out.println("O usuario " + usuario.getNome() + " recebeu "+ ((Professor) usuario).getContadorNotificacoes() + " notificações.");
    }

    public static void imprimirEmprestimosCorrentes(Usuario usuario) {
        System.out.println("Empréstimos Correntes:");
        for (Emprestimo emprestimo : GerenciadorEmprestimos.getInstance().procurarEmprestimosPorUsuario(usuario)) {
            System.out.println("Título: " + emprestimo.getExemplar().getLivro().getTitulo());
            System.out.println("Data do Empréstimo: " + emprestimo.getDataEmprestimo());
            System.out.println("Status: " + (emprestimo.isFinalizado() ? "Finalizado" : "Em curso"));
            System.out.println("Data de Devolução: " + (emprestimo.isFinalizado() ? emprestimo.getFoiDevolvido() : emprestimo.getDataDevolucao()));
            System.out.println();
        }
    }

    public static void imprimirEmprestimosPassados(Usuario usuario) {
        System.out.println("Empréstimos Passados:");
        for (Emprestimo emprestimo : usuario.listarEmprestimosPassados()) {
            System.out.println("Título: " + emprestimo.getExemplar().getLivro().getTitulo());
            System.out.println("Data do Empréstimo: " + emprestimo.getDataEmprestimo());
            System.out.println("Status: " + (emprestimo.isFinalizado() ? "Finalizado" : "Em curso"));
            System.out.println("Data de Devolução: " + (emprestimo.isFinalizado() ? emprestimo.getFoiDevolvido() : emprestimo.getDataDevolucao()));
            System.out.println();
        }
    }

    public static void imprimirReservas(Usuario usuario) {
        System.out.println("Reservas:");
        for (Reserva reserva : GerenciadorReservas.getInstance().procurarReservasPorUsuario(usuario)) {
            System.out.println("Título: " + reserva.getLivro().getTitulo());
            System.out.println("Data da Solicitação: " + reserva.getDataReserva());
            System.out.println();
        }
    }

    public static void imprimirSucessoDevolucao(Usuario usuario, Livro livro){
        System.out.println("Devolução realizada com sucesso para o usuário " + usuario.getNome() + " do livro " + livro.getTitulo());
    }

    public static void imprimirFalhaDevolucao(Usuario usuario, Livro livro){
        System.out.println("Devolução não realizada, pois o usuário " + usuario.getNome() + " não tem empréstimo em aberto do livro " + livro.getTitulo());
    }

    public static void imprimirSucessoReserva(Usuario usuario, Livro livro){
        System.out.println("Reserva realizada com sucesso para o usuário " + usuario.getNome() + " do livro " + livro.getTitulo());
        }

        public static void imprimirFalhaReserva(Usuario usuario, Livro livro){
        System.out.println("Reserva não realizada para o usuário " + usuario.getNome() + " do livro " + livro.getTitulo() + "pois ele excedeu o limite de reservas.");
    }

    public static void imprimirSucessoEmprestimo(Usuario usuario, Livro livro) {
        System.out.println("Empréstimo do livro " + livro.getTitulo() + "realizado com sucesso para o usuário: " + usuario.getNome());
    }

    public static void imprimirFalhaEmprestimo(Usuario usuario, Livro livro, String motivo) {
        System.out.println("O usuário " + usuario.getNome() + " não conseguiu realizar o empréstimo do livro " + livro.getTitulo() + ", pois " + motivo);
    }

    public static void imprimirSucessoObservacao(Usuario usuario, Livro livro) {
        System.out.println("Observação realizada com sucesso para o usuário " + usuario.getNome() + " do livro " + livro.getTitulo());
    }

    public static void imprimirComandoNaoReconhecido(String strComando){
        System.out.println("Comando não reconhecido: " + strComando);
    }

    public static void imprimirMensagemInicial(){
        System.out.println("\n Bem-vindo ao Sistema da Biblioteca");
    }

    public static void imprimirMensagemFinal(){
        System.out.println("\n Obrigado por utilizar o Sistema da Biblioteca");
    }

    public static void imprimirMenu(){
        System.out.println("\nDigite um comando (emp, usu, dev, res, obs, liv, ntf, sai): ");
    }
}
