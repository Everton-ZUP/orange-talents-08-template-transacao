package br.com.zupedu.trasacao.consumir;

import br.com.zupedu.trasacao.TestPrincipal;
import br.com.zupedu.trasacao.registro.transacao.Transacao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

class ListenerDeTransacaoTest extends TestPrincipal {

    @Test
    public void deveriaCadastrarUmaTransacao(){
        TransacaoForm transacaoForm = criaTransacaoFormValida();
        super.listenerDeTransacao.ouvir(transacaoForm);

        List<Transacao> lista = transacaoRepository.findAll();
        Assertions.assertTrue(!lista.isEmpty(),"a lista não pode retornar vazia");
    }





    private TransacaoForm criaTransacaoFormValida() {
        TransacaoForm transacaoForm = new TransacaoForm();
        ReflectionTestUtils.setField(transacaoForm,"id","123456");
        ReflectionTestUtils.setField(transacaoForm,"valor",new BigDecimal(100));
        ReflectionTestUtils.setField(transacaoForm,"efetivadaEm", LocalDateTime.now());
        ReflectionTestUtils.setField(transacaoForm,"estabelecimento", criaEstabelecimentoValido());
        ReflectionTestUtils.setField(transacaoForm,"cartao", criaCartaoValido());

        return transacaoForm;
    }

    private CartaoForm criaCartaoValido() {
        CartaoForm cartao = new CartaoForm();
        ReflectionTestUtils.setField(cartao,"id","123124123");
        ReflectionTestUtils.setField(cartao,"email","teste@teste.com");
        return cartao;
    }

    private EstabelecimentoForm criaEstabelecimentoValido() {
        EstabelecimentoForm estabelecimento = new EstabelecimentoForm();
        ReflectionTestUtils.setField(estabelecimento,"nome","Teste");
        ReflectionTestUtils.setField(estabelecimento,"cidade","São Teste");
        ReflectionTestUtils.setField(estabelecimento,"endereco","rua 123");
        return estabelecimento;
    }
}
