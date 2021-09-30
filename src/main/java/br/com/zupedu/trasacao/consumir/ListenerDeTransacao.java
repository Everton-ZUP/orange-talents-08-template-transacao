package br.com.zupedu.trasacao.consumir;

import br.com.zupedu.trasacao.registro.cartao.CartaoRepository;
import br.com.zupedu.trasacao.registro.transacao.Transacao;
import br.com.zupedu.trasacao.registro.transacao.TransacaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class ListenerDeTransacao {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private CartaoRepository cartaoRepository;

    @KafkaListener(topics = "${spring.kafka.topic.transacao}")
    @Transactional
    public void ouvir(TransacaoForm eventoMensagem) {
        try {

            Transacao transacao = eventoMensagem.toTransacao(cartaoRepository);
            transacaoRepository.save(transacao);
            logger.info("Transação recebida do Kafka e salva com sucesso; id_Mensagem = " + eventoMensagem.getId() + " id_Banco: " + transacao.getId());

        } catch (Exception exception){

            logger.error("Não foi possível transformar o retorno do kafka em uma transação e salvar no banco de dados; Mensagem do Kafka: "
                    +eventoMensagem.getId()+"Menssagem Erro: "+exception.getMessage());

        }
    }

}
