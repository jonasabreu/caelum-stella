package br.com.caelum.stella.boleto;

/**
 * Bean que representa os dados do emissor de um Boleto.
 * 
 * @author Paulo Silveira
 * @author Caue Guerra
 * 
 */
public class Emissor {
	private int agencia;
	private char dvAgencia;
	private long contaCorrente;
	private int carteira;
	private long numConvenio;
	private String nossoNumero;
	private String cedente;
	private char dvContaCorrente;
	private char dvNossoNumero;
	private int codOperacao;
	private int codFornecidoPelaAgencia;

	private Emissor() {
	}

	/**
	 * Cria novo emissor
	 * 
	 * @return
	 */
	public static Emissor newEmissor() {
		return new Emissor();
	}

	/**
	 * Devolve o número da agencia sem o digito
	 * 
	 */
	public int getAgencia() {
		return agencia;
	}

	/**
	 * Associa uma agencia, SEM o dígito verificador, ao emissor
	 * 
	 * @param agencia
	 */
	public Emissor withAgencia(int agencia) {
		this.agencia = agencia;
		return this;
	}

	/**
	 * Devolve o número da conta corrente sem o digito
	 * 
	 */
	public long getContaCorrente() {
		return contaCorrente;
	}

	/**
	 * Associa uma conta corrente, SEM o dígito verificador, ao emissor
	 * 
	 * @param contaCorrente
	 */
	public Emissor withContaCorrente(long contaCorrente) {
		this.contaCorrente = contaCorrente;
		return this;
	}

	/**
	 * Devolve a carteira<br/>
	 * Valor informado pelo banco para identificação do tipo de boleto
	 * 
	 */
	public int getCarteira() {
		return carteira;
	}

	/**
	 * Associa uma carteira ao emissor<br/>
	 * Valor informado pelo banco para identificação do tipo de boleto
	 * 
	 * @param carteira
	 */
	public Emissor withCarteira(int carteira) {
		this.carteira = carteira;
		return this;
	}

	/**
	 * Devolve o número do convênio<br/>
	 * Valor que identifica um emissor junto ao seu banco para associar seus
	 * boletos<br/>
	 * Valor informado pelo banco
	 * 
	 */
	public long getNumConvenio() {
		return numConvenio;
	}

	/**
	 * Associa um número de convênio ao emissor<br/>
	 * Valor que identifica um emissor junto ao seu banco para associar seus
	 * boletos<br/>
	 * Valor informado pelo banco
	 * 
	 * @param numConvenio
	 */
	public Emissor withNumConvenio(long numConvenio) {
		this.numConvenio = numConvenio;
		return this;
	}

	/**
	 * Devolve o nosso número<br/>
	 * Valor que o cedente escolhe para manter controle sobre seus boletos. Esse
	 * valor serve para o cedente identificar quais boletos foram pagos ou não.
	 * Recomenda-se o uso de números sequenciais, na geração de diversos
	 * boletos, para facilitar a identificação dos boletos pagos
	 * 
	 */
	public String getNossoNumero() {
		return nossoNumero;
	}

	/**
	 * Associa o nosso número ao emissor<br/>
	 * Valor que o cedente escolhe para manter controle sobre seus boletos. Esse
	 * valor serve para o cedente identificar quais boletos foram pagos ou não.
	 * Recomenda-se o uso de números sequenciais, na geração de diversos
	 * boletos, para facilitar a identificação dos boletos pagos
	 * 
	 * @param nossoNumero
	 */
	public Emissor withNossoNumero(String nossoNumero) {
		this.nossoNumero = nossoNumero;
		return this;
	}

	/**
	 * Devolve o cedente. (nome do emissor)
	 * 
	 */
	public String getCedente() {
		return cedente;
	}

	/**
	 * Associa um cedente (nome) ao emissor
	 * 
	 * @param cedente
	 */
	public Emissor withCedente(String cedente) {
		this.cedente = cedente;
		return this;
	}

	/**
	 * Devolve o digito verificador (DV) da conta corrente
	 * 
	 * @return
	 */
	public char getDvContaCorrente() {
		return dvContaCorrente;
	}

	/**
	 * Associa um digito verificador (DV) da conta corrente ao emissor
	 * 
	 * @param dv
	 * @return
	 */
	public Emissor withDvContaCorrente(char dv) {
		dvContaCorrente = dv;
		return this;
	}

	/**
	 * Devolve o digito verificador (DV) da agencia
	 * 
	 * @return
	 */
	public char getDvAgencia() {
		return dvAgencia;
	}

	/**
	 * Associa um digito verificador (DV) da agencia ao emissor
	 * 
	 * @param dv
	 * @return
	 */
	public Emissor withDvAgencia(char dv) {
		dvAgencia = dv;
		return this;
	}

	/**
	 * Devolve a agencia formatada (com 4 digitos)
	 * 
	 * @return
	 */
	public String getAgenciaFormatado() {
		return String.format("%04d", agencia);
	}

	/**
	 * Devolve o código de operação do emissor.
	 * 
	 * @return
	 */
	public int getCodOperacao() {
		return codOperacao;
	}

	/**
	 * Associa um código de operação ao emissor.
	 * 
	 * @param codOperacao
	 * @return
	 */
	public Emissor withCodOperacao(int codOperacao) {
		this.codOperacao = codOperacao;
		return this;
	}

	/**
	 * Devolve o código fornecido pela agência do emissor.
	 * 
	 * @return
	 */
	public int getCodFornecidoPelaAgencia() {
		return codFornecidoPelaAgencia;
	}

	/**
	 * Associa um código fornecido pela agência ao emissor.
	 * 
	 * @param codFornecidoPelaAgencia
	 * @return
	 */
	public Emissor withCodFornecidoPelaAgencia(int codFornecidoPelaAgencia) {
		this.codFornecidoPelaAgencia = codFornecidoPelaAgencia;
		return this;
	}

	/**
	 * Associa o DV do nosso número ao emissor
	 * 
	 * @param dvNossoNumero
	 */
	public Emissor withDvNossoNumero(char dvNossoNumero) {
		this.dvNossoNumero = dvNossoNumero;
		return this;
	}

	/**
	 * Devolve o DV no nosso número associado ao emissor
	 * 
	 * @return
	 */
	public char getDvNossoNumero() {
		return dvNossoNumero;
	}
}
