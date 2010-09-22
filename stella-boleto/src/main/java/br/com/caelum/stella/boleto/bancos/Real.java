package br.com.caelum.stella.boleto.bancos;

import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Emissor;

public class Real implements Banco {

	private final static String NUMERO_REAL = "356";

	private final DVGenerator dvGenerator = new DVGenerator();

	public String geraCodigoDeBarrasPara(Boleto boleto) {
		StringBuilder codigoDeBarras = new StringBuilder();
		codigoDeBarras.append(getNumeroFormatado());
		codigoDeBarras.append(String.valueOf(boleto.getCodEspecieMoeda()));
		// Digito Verificador sera inserido aqui.

		codigoDeBarras.append(boleto.getFatorVencimento());
		codigoDeBarras.append(boleto.getValorFormatado());

		Emissor emissor = boleto.getEmissor();

		codigoDeBarras.append(emissor.getAgenciaFormatado());
		codigoDeBarras.append(getContaCorrenteDoEmissorFormatado(emissor));

		codigoDeBarras.append(calculaDigitaoDeCobranca(emissor));

		codigoDeBarras.append(getNossoNumeroDoEmissorFormatado(emissor));

		codigoDeBarras.insert(4, dvGenerator.geraDVMod11(codigoDeBarras.toString()));

		return codigoDeBarras.toString();
	}

	/**
	 * Calculo relacionado apenas ao Banco Real
	 * 
	 * @param emissor
	 * @return
	 */
	private int calculaDigitaoDeCobranca(Emissor emissor) {
		return dvGenerator.geraDVMod10(getNossoNumeroDoEmissorFormatado(emissor) + emissor.getAgenciaFormatado()
				+ getContaCorrenteDoEmissorFormatado(emissor));
	}

	public URL getImage() {
		return getClass().getResource(String.format("/br/com/caelum/stella/boleto/img/%s.png", getNumeroFormatado()));
	}

	public String getNumeroFormatado() {
		return NUMERO_REAL;
	}

	public String getCarteiraDoEmissorFormatado(Emissor emissor) {
		return String.format("%02d", emissor.getCarteira());
	}

	public String getContaCorrenteDoEmissorFormatado(Emissor emissor) {
		return String.format("%07d", emissor.getContaCorrente());
	}

	public String getNossoNumeroDoEmissorFormatado(Emissor emissor) {
		NumberFormat numberFormat = new DecimalFormat("0000000000000");
		return numberFormat.format(new Long(emissor.getNossoNumero()));
	}

}
