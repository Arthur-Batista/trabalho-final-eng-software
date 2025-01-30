public class ConsultarUsuario {
    public void consultarUsuario(Usuario usuario) {
        System.out.println("Empréstimos Correntes:");
        for (Emprestimo emprestimo : GerenciadorEmprestimos.procurarEmprestimosPorUsuario(usuario)) {
            System.out.println("Título: " + emprestimo.getExemplar().getLivro().getTitulo());
            System.out.println("Data do Empréstimo: " + emprestimo.getDataEmprestimo());
            System.out.println("Status: " + (emprestimo.isFinalizado() ? "Finalizado" : "Em curso"));
            System.out.println("Data de Devolução: " + (emprestimo.isFinalizado() ? emprestimo.foiDevolvido() : emprestimo.getDataDevolucao()));
            System.out.println();
        }

        System.out.println("Empréstimos Passados:");
        for (Emprestimo emprestimo : usuario.getEmprestimosPassados()) {
            System.out.println("Título: " + emprestimo.getExemplar().getLivro().getTitulo());
            System.out.println("Data do Empréstimo: " + emprestimo.getDataEmprestimo());
            System.out.println("Status: " + (emprestimo.isFinalizado() ? "Finalizado" : "Em curso"));
            System.out.println("Data de Devolução: " + (emprestimo.isFinalizado() ? emprestimo.foiDevolvido() : emprestimo.getDataDevolucao()));
            System.out.println();
            }
        }

        System.out.println("Reservas:");
        for (Reserva reserva : GerenciadorReservas.procurarReservasPorUsuario(usuario)) {
            System.out.println("Título: " + reserva.getLivro().getTitulo());
            System.out.println("Data da Solicitação: " + reserva.getDataReserva());
            System.out.println();
        }
    }
