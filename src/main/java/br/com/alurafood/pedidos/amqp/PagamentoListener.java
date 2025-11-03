package br.com.alurafood.pedidos.amqp;

import br.com.alurafood.pedidos.dto.PagamentoDto;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PagamentoListener {


    @RabbitListener(queues = "pagamento.concluido")
    public void recebeMensagem(PagamentoDto pagamentoDto) {
        String mensagem = """
               Dados do pagamento: %s
               Número do pedido: %s
               Nome: %s
               Valor R$: %s
               Status: %s 
           """.formatted(pagamentoDto.getId(), pagamentoDto.getPedidoId(), pagamentoDto.getNome(),  pagamentoDto.getValor(), pagamentoDto.getStatus());

        System.out.println("Recebi a mensagem " + mensagem);
    }
}
