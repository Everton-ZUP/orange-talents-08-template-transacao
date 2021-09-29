package br.com.zupedu.trasacao.consumir;

import br.com.zupedu.trasacao.registro.cartao.Cartao;
import br.com.zupedu.trasacao.registro.cartao.CartaoRepository;
import br.com.zupedu.trasacao.registro.transacao.Estabelecimento;
import br.com.zupedu.trasacao.registro.transacao.Transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoForm {

    private String id;
    private BigDecimal valor;
    private LocalDateTime efetivadaEm;

    private EstabelecimentoForm estabelecimento;
    private CartaoForm cartao;

    public Transacao toTransacao(CartaoRepository cartaoRepository) {
        Cartao card = cartaoRepository.findByNumeroCartao(cartao.getId()).orElse(cartao.toCartao());
        Estabelecimento estab = estabelecimento.toEstabelecimento();
        return new Transacao(id,valor,efetivadaEm,estab,card);
    }

    public String getId() {
        return id;
    }
    public BigDecimal getValor() {
        return valor;
    }
    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
    public EstabelecimentoForm getEstabelecimento() {
        return estabelecimento;
    }
    public CartaoForm getCartao() {
        return cartao;
    }

}
