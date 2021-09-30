package br.com.zupedu.trasacao.registro.transacao;

import br.com.zupedu.trasacao.registro.cartao.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransacaoRepository extends JpaRepository<Transacao,Long> {
    List<Transacao> findTop10ByCartaoOrderByEfetivadaEmDesc(Cartao cartao);
}
