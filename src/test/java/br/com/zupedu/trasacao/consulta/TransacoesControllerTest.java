package br.com.zupedu.trasacao.consulta;

import br.com.zupedu.trasacao.TestPrincipal;
import br.com.zupedu.trasacao.registro.cartao.Cartao;
import br.com.zupedu.trasacao.registro.transacao.Estabelecimento;
import br.com.zupedu.trasacao.registro.transacao.Transacao;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.time.LocalDateTime;

class TransacoesControllerTest extends TestPrincipal {

    @Test
    public void deveriaRetornarListaDeTransacoesDto() throws Exception {

        Transacao transacao = criarTransacaoNoBanco();

        mockMvc.perform(MockMvcRequestBuilders.get("/cartoes/" + transacao.getCartao().getId() + "/transacoes"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void deveriaLancarExcecaoAoBuscarCartaoQueNaoExiste() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/cartoes/1111hujhuhj122222333333/transacoes"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    private Transacao criarTransacaoNoBanco() {
        Estabelecimento estabelecimento = new Estabelecimento("Teste","teste","teste123");
        Cartao cartao = new Cartao("123","teste@teste.com");
        Transacao transacao = new Transacao("1234",new BigDecimal(100), LocalDateTime.now(), estabelecimento, cartao);
        transacao = transacaoRepository.save(transacao);
        return transacao;
    }

}