package br.com.zupedu.trasacao.registro.cartao;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;

@Entity
public class Cartao {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(unique = true)
    private String numeroCartao;
    @Email
    private String email;

    public Cartao(String id, String email) {
        this.numeroCartao = id;
        this.email = email;
    }

    public Cartao() {
    }
}
