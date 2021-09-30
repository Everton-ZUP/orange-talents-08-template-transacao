package br.com.zupedu.trasacao;

import br.com.zupedu.trasacao.consumir.ListenerDeTransacao;
import br.com.zupedu.trasacao.registro.cartao.CartaoRepository;
import br.com.zupedu.trasacao.registro.transacao.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
public class TestPrincipal {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ListenerDeTransacao listenerDeTransacao;

    @Autowired
    protected TransacaoRepository transacaoRepository;

    @Autowired
    protected CartaoRepository cartaoRepository;
}
