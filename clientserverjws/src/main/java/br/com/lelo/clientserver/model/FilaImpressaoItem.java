package br.com.lelo.clientserver.model;

public class FilaImpressaoItem {

	public String text;
	private String autor;
	private int size;
	private String fila;

	public FilaImpressaoItem(String text, String autor, String fila) {
		super();
		this.text = text;
		this.autor = autor;
		this.fila = fila;
		this.size = text.length();
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getSize() {
		return size;
	}

	public String getFila() {
		return fila;
	}

	public void setFila(String fila) {
		this.fila = fila;
	}
}
