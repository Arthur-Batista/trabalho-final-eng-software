public class ConsultarLivro {
    public void consultarLivro(Livro livro) {
        System.out.println("Título: " + livro.getTitulo());
        System.out.println("Quantidade de reservas: " + GerenciadorReservas.getQuantidadeReservasPorLivro(livro));

        if (GerenciadorReservas.getQuantidadeReservasPorLivro(livro) > 0) {
            System.out.println("Usuários que realizaram reservas:");
            for (Reserva reserva : GerenciadorReservas.procurarReservasPorLivro(livro)) {
            System.out.println(" - " + reserva.getUsuario().getNome());
            }
        }

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

   