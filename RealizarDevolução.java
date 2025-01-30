public class RealizarDevolucao {
    public void realizarDevolucao(Usuario usuario,Livro livro) {
       if(GerenciadorEmprestimos.verificarEmprestimo(usuario, livro)){
           Emprestimo emprestimo = GerenciadorEmprestimos.retornarEmprestimo(usuario, livro);
           Exemplar exemplar = emprestimo.getExemplar();
           exemplar.setDisponivel(true);
           exemplar.setEmprestimo(null);
           emprestimo.setFoiDevolvido(LocalDate.now());
           emprestimo.setIsFinalizado(true);
           usuario.adicionarEmprestimosPassados(emprestimo);
           GerenciadorEmprestimos.removerEmprestimo(emprestimo);
       }    
       else{
           System.out.println("Usuário não possui empréstimo do livro");
       }
    }
}