package br.com.alura.mvc.mudi.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Pedido {

	private String nomeProduto;
	private BigDecimal valorNegociado;
	private LocalDate dataDeEntrega;
	private String urlProduto;
	private String urlImagem;
	private String descricao;
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public BigDecimal getValorNegociado() {
		return valorNegociado;
	}
	public void setValorNegociado(BigDecimal valorNegociado) {
		this.valorNegociado = valorNegociado;
	}
	public LocalDate getDataDeEntrega() {
		return dataDeEntrega;
	}
	public void setDataDeEntrega(LocalDate dataDeEntrega) {
		this.dataDeEntrega = dataDeEntrega;
	}
	public String getUrlProduto() {
		return urlProduto;
	}
	public void setUrlProduto(String urlProduto) {
		this.urlProduto = urlProduto;
	}
	public String getUrlImagem() {
		return urlImagem;
	}
	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
