package br.edu.unisep.biblioteca.view;

import br.edu.unisep.biblioteca.model.*;
import br.edu.unisep.biblioteca.model.livro;
import br.edu.unisep.biblioteca.model.usuario;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SistemaBiblioteca extends JFrame {
    private ArrayList<livro> livros;
    private ArrayList<usuario> usuarios;
    private ArrayList<emprestimo> emprestimos;

    public SistemaBiblioteca() {
        livros = new ArrayList<>();
        usuarios = new ArrayList<>();
        emprestimos = new ArrayList<>();
        initUI();
    }

    private void initUI() {
        setTitle("Sistema de Biblioteca");
        setSize(600, 500);
        setLocationRelativeTo(null);  // Centra a janela na tela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Botão para cadastro de livros
        JButton botaoCadastrarLivro = new JButton("Cadastrar Livro");
        botaoCadastrarLivro.addActionListener(e -> mostrarCadastroLivro());

        // Botão para listar livros
        JButton botaoListarLivros = new JButton("Listar Livros");
        botaoListarLivros.addActionListener(e -> listarLivros());

        // Botão para consultar livros disponíveis
        JButton botaoConsultarDisponiveis = new JButton("Consultar Livros Disponíveis");
        botaoConsultarDisponiveis.addActionListener(e -> consultarLivrosDisponiveis());

        // Botão para listar livros no empréstimo
        JButton botaoListarEmprestimos = new JButton("Listar Livros no Empréstimo");
        botaoListarEmprestimos.addActionListener(e -> listarLivrosEmprestados());

        // Botão para adicionar usuário
        JButton botaoAdicionarUsuario = new JButton("Adicionar Usuário");
        botaoAdicionarUsuario.addActionListener(e -> mostrarCadastroUsuario());

        // Botão para empréstimo de livro
        JButton botaoPegarEmprestado = new JButton("Pegar Livro Emprestado");
        botaoPegarEmprestado.addActionListener(e -> mostrarEmprestimoLivro());

        // Adicionando botões ao painel
        add(botaoCadastrarLivro);
        add(botaoListarLivros);
        add(botaoConsultarDisponiveis);
        add(botaoListarEmprestimos);
        add(botaoAdicionarUsuario);
        add(botaoPegarEmprestado);
    }

    private void listarLivros() {
        StringBuilder listaLivros = new StringBuilder("Livros cadastrados:\n");
        for (livro livro : livros) {
            listaLivros.append(livro.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(this, listaLivros.toString());
    }

    private void consultarLivrosDisponiveis() {
        StringBuilder livrosDisponiveis = new StringBuilder("Livros Disponíveis:\n");
        for (livro livro : livros) {
            boolean emprestado = false;
            for (emprestimo emp : emprestimos) {
                if (emp.getLivro().equals(livro) && emp.getStatus().equals("Em Empréstimo")) {
                    emprestado = true;
                    break;
                }
            }
            if (!emprestado) {
                livrosDisponiveis.append(livro.toString()).append("\n");
            }
        }
        JOptionPane.showMessageDialog(this, livrosDisponiveis.toString());
    }

    private void listarLivrosEmprestados() {
        StringBuilder livrosEmprestados = new StringBuilder("Livros no Empréstimo:\n");
        for (emprestimo emprestimo : emprestimos) {
            if (emprestimo.getStatus().equals("Em Empréstimo")) {
                livrosEmprestados.append(emprestimo.getLivro().toString()).append(" - Emprestado para: ")
                        .append(emprestimo.getUsuario().getNome()).append("\n");
            }
        }
        JOptionPane.showMessageDialog(this, livrosEmprestados.toString());
    }

    private void mostrarCadastroLivro() {
        JFrame frameCadastroLivro = new JFrame("Cadastro de Livro");
        frameCadastroLivro.setSize(400, 400);
        frameCadastroLivro.setLayout(new GridLayout(9, 2));

        JTextField campoTitulo = new JTextField();
        JTextField campoAutor = new JTextField();
        JTextField campoGenero = new JTextField();
        JTextField campoIsbn = new JTextField();
        JTextField campoAnoPublicacao = new JTextField();
        JTextField campoEditora = new JTextField();

        JButton botaoFisico = new JButton("Livro Físico");
        JButton botaoDigital = new JButton("Livro Digital");

        String[] tipoLivro = new String[1];

        botaoFisico.addActionListener(e -> tipoLivro[0] = "Físico");
        botaoDigital.addActionListener(e -> tipoLivro[0] = "Digital");

        JButton botaoSalvar = new JButton("Salvar");
        botaoSalvar.addActionListener(e -> {
            try {
                String titulo = campoTitulo.getText();
                String autor = campoAutor.getText();
                String genero = campoGenero.getText();
                String isbn = campoIsbn.getText();
                int anoPublicacao = Integer.parseInt(campoAnoPublicacao.getText());
                String editora = campoEditora.getText();

                if ("Físico".equals(tipoLivro[0])) {
                    livros.add(new livroFisico(titulo, autor, genero, isbn, anoPublicacao, editora, "Codigo123"));
                } else if ("Digital".equals(tipoLivro[0])) {
                    livros.add(new livroDigital(titulo, autor, genero, isbn, anoPublicacao, editora, "http://livro.com"));
                }

                JOptionPane.showMessageDialog(frameCadastroLivro, "Livro cadastrado com sucesso!");
                frameCadastroLivro.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frameCadastroLivro, "Ano de publicação deve ser um número válido!");
            }
        });

        frameCadastroLivro.add(new JLabel("Título:"));
        frameCadastroLivro.add(campoTitulo);
        frameCadastroLivro.add(new JLabel("Autor:"));
        frameCadastroLivro.add(campoAutor);
        frameCadastroLivro.add(new JLabel("Gênero:"));
        frameCadastroLivro.add(campoGenero);
        frameCadastroLivro.add(new JLabel("ISBN:"));
        frameCadastroLivro.add(campoIsbn);
        frameCadastroLivro.add(new JLabel("Ano de Publicação:"));
        frameCadastroLivro.add(campoAnoPublicacao);
        frameCadastroLivro.add(new JLabel("Editora:"));
        frameCadastroLivro.add(campoEditora);

        frameCadastroLivro.add(botaoFisico);
        frameCadastroLivro.add(botaoDigital);
        frameCadastroLivro.add(botaoSalvar);

        frameCadastroLivro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameCadastroLivro.setVisible(true);
    }

    private void mostrarCadastroUsuario() {
        JTextField campoNomeUsuario = new JTextField();
        int opcao = JOptionPane.showConfirmDialog(this, campoNomeUsuario, "Digite o nome do usuário", JOptionPane.OK_CANCEL_OPTION);
        if (opcao == JOptionPane.OK_OPTION) {
            String nome = campoNomeUsuario.getText();
            usuarios.add(new usuario(nome));
            JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso!");
        }
    }

    private void mostrarEmprestimoLivro() {
        String nomeUsuario = JOptionPane.showInputDialog(this, "Digite o nome do usuário que pegará o livro:");
        usuario usuario = usuarios.stream().filter(u -> u.getNome().equals(nomeUsuario)).findFirst().orElse(null);
        if (usuario != null) {
            // Solicitar o título do livro para empréstimo
            String tituloLivro = JOptionPane.showInputDialog(this, "Digite o título do livro que será emprestado:");

            // Buscar o livro na lista de livros cadastrados
            livro livro = null;
            for (livro l : livros) {
                if (l.getTitulo().equals(tituloLivro)) {
                    livro = l;
                    break;
                }
            }

            if (livro != null) {
                // Verificar se o livro está emprestado
                boolean livroEmprestado = false;
                for (emprestimo emp : emprestimos) {
                    if (emp.getLivro().equals(livro) && emp.getStatus().equals("Em Empréstimo")) {
                        livroEmprestado = true;
                        break;
                    }
                }

                if (!livroEmprestado) {
                    // Realizar o empréstimo
                    emprestimos.add(new emprestimo(livro, usuario, "Em Empréstimo"));
                    JOptionPane.showMessageDialog(this, "Empréstimo realizado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(this, "Livro já está emprestado.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Livro não encontrado.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Usuário não encontrado.");
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SistemaBiblioteca().setVisible(true));
    }
}
