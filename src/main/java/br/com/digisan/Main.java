package br.com.digisan;

import br.com.digisan.model.*;
import br.com.digisan.model.nfse.*;

import java.math.BigDecimal;
import java.util.UUID;

public class Main {
    public static void main(String[] args) throws DigisanException {
        Digisan.init("ak_live_123");
        cancelar();
//        emiteNfse();
    }

    private static void cancelar() throws DigisanException {
        new Nfse().solicitarCancelamento("6578bfcd6e90483806e117ea", CodigoCancelamento.SERVICO_NAO_PRESTADO, "Nota emitida para testes");
    }

    private static void emiteNfse() throws DigisanException {
        Nfse nfse = new Nfse();
        nfse.setIdExterno(UUID.randomUUID().toString());
        nfse.setPrestador(new Prestador("03610650000147"));
        Tomador tomador = new Tomador();
        tomador.setNome("Lucas da Silva Moreira");
        tomador.setCpfCnpj("04163423109");
        tomador.setTelefone("61992741523");
        tomador.setEmail("lucas@digisan.com.br");
        tomador.setTipoPessoa(TipoPessoa.FISICA);
        Endereco endereco = new Endereco();
        endereco.setUf("DF");
        Municipio m = new Municipio();
        m.setCodigoIbge("5300108");
        endereco.setMunicipio(m);
        endereco.setLogradouro("Rua 8 CH 331 Lote 11 A");
        endereco.setComplemento("Cond Belo Horizonte");
        endereco.setNumero("11A");
        endereco.setBairro("Vicente Pires");
        endereco.setCep("72007120");
        tomador.setEndereco(endereco);
        nfse.setTomador(tomador);
        Servico servico = new Servico();
        servico.setDescricao("Meu serviço de teste");
        servico.setCnae("8599603");
        servico.setCodigoMunicipio("5300108");
        servico.setCodigoMunicipioIncidencia("5300108");
        servico.setItemListaServicoLC116("08.02");
        servico.setCodigoTributacaoMunicipio("802");
        servico.setIndicadorExigibilidade(IndicadorExigibilidade.EXIGIVEL);
        servico.setIssRetido(false);
        servico.setValorServicos(BigDecimal.TEN);
        servico.setAliquotaIss(BigDecimal.ZERO);
        nfse.setServico(servico);
        nfse.setInformacoesAdicionais("Teste");
        EnviarNfseResponse response = nfse.enviar();
        System.out.println(response.getId());
    }
}