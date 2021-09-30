package br.com.zupedu.trasacao.registro.transacao;

import br.com.zupedu.trasacao.registro.cartao.Cartao;

import javax.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Transacao {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String idMensagem;
    private BigDecimal valor;
    private LocalDateTime efetivadaEm;

    @Embedded
    private Estabelecimento estabelecimento;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cartao_id")
    private Cartao cartao;

    public Transacao(String idMensagem, BigDecimal valor, LocalDateTime efetivadaEm, Estabelecimento estabelecimento, Cartao cartao) {
        this.idMensagem = idMensagem;
        this.valor = valor;
        this.efetivadaEm = efetivadaEm;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
    }

    public Transacao() {
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }
}
