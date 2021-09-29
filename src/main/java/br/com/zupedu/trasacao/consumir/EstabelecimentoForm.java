package br.com.zupedu.trasacao.consumir;

import br.com.zupedu.trasacao.registro.transacao.Estabelecimento;

public class EstabelecimentoForm {

    private String nome;
    private String cidade;
    private String endereco;

    public Estabelecimento toEstabelecimento() {
        return new Estabelecimento(nome,cidade,endereco);
    }

    public String getNome() {
        return nome;
    }
    public String getCidade() {
        return cidade;
    }
    public String getEndereco() {
        return endereco;
    }

}
