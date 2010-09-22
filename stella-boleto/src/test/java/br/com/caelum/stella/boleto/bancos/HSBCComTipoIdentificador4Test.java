package br.com.caelum.stella.boleto.bancos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Emissor;
import br.com.caelum.stella.boleto.Sacado;

public class HSBCComTipoIdentificador4Test {
	private Boleto boleto;
	private Banco banco;
	/*
	 * no documento informa, que a carteira deve ser CNR
	 */
	private final int carteiraSimbolica = 0;

	@Before
	public void setUp() {

		Datas datas = Datas.newDatas().withDocumento(3, 7, 2000).withVencimento(4, 7, 2000);

		Emissor emissor = Emissor.newEmissor().withCedente("Alberto").withAgencia(501).withContaCorrente(6703255)
				.withNossoNumero("39104766").withCodFornecidoPelaAgencia(351202).withCarteira(carteiraSimbolica);

		Sacado sacado = Sacado.newSacado().withNome("Fulano").withCidade("Salvador").withBairro("Rio Vermelho")
				.withCep("40000000").withEndereco("Endereco em salvador").withCpf("94312885087").withUf("BA");

		banco = new HSBC();

		boleto = Boleto.newBoleto().withDatas(datas).withEmissor(emissor).withSacado(sacado).withValorBoleto("1200.00")
				.withNoDocumento("39104766");
	}

	@Test
	public void testCodigoDoDocumentoFinalComDigitosVerificadores() {
		boleto = boleto.withBanco(banco);
		assertEquals("39104766340", ((HSBC) banco).getCodigoDoDocumentoFinalComDigitosVerificadores(boleto));
	}

	@Test
	public void testLinhaDoBancoHSBC() {
		boleto = boleto.withBanco(banco);

		assertEquals("39990.35128  02000.003919  04766.186029  3  10010000120000", new LinhaDigitavelGenerator()
				.geraLinhaDigitavelPara(boleto));
	}

	@Test
	public void testDataJuliana() {
		HSBC hsbc = (HSBC) banco;
		Assert.assertEquals("1860", hsbc.getDataFormatoJuliano(boleto.getDatas().getVencimento(), 4));
	}

	@Test
	public void testCodigoDeBarraDoBancoHSBC() {
		boleto = boleto.withBanco(banco);
		assertEquals("39993100100001200000351202000003910476618602", banco.geraCodigoDeBarrasPara(boleto));
	}

	@Test
	public void testGetImage() throws IOException {
		assertNotNull(banco.getImage());
	}

}