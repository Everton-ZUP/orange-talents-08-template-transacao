package br.com.zupedu.trasacao.consumir;

import br.com.zupedu.trasacao.registro.cartao.Cartao;

public class CartaoForm {
    private String id;
    private String email;

    public Cartao toCartao() {
        return new Cartao(id,email);
    }

    public String getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }

}
