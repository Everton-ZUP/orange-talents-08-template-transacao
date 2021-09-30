package br.com.zupedu.trasacao.consulta;

import br.com.zupedu.trasacao.registro.cartao.Cartao;
import br.com.zupedu.trasacao.registro.cartao.CartaoRepository;
import br.com.zupedu.trasacao.registro.transacao.Transacao;
import br.com.zupedu.trasacao.registro.transacao.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cartoes/{id}/transacoes")
public class TransacoesController {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private CartaoRepository cartaoRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<?> buscar(@PathVariable String id){
        Cartao cartao = cartaoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cartão não encontrado"));
        List<Transacao> transacoes = transacaoRepository.findTop10ByCartaoOrderByEfetivadaEmDesc(cartao);
        List<TransacaoDTO> transacoesDTO =transacoes.stream().map(TransacaoDTO::new).collect(Collectors.toList());
        return transacoesDTO;
    }
}
