package model;

public class Publicacao {
	private int idPublicacao;
	private String tituloPublicacao;
	private String categoriaPublicacao;
	private String conteudoPublicacao;
	private Blog idBlog;
	
	public Publicacao(){
		
	}
	
	public Publicacao(int idPublicacao, String tituloPublicacao, String categoriaPublicacao, 
			String conteudoPublicacao, Blog idBlog){
		this.idPublicacao = idPublicacao;
		this.tituloPublicacao = tituloPublicacao;
		this.categoriaPublicacao = categoriaPublicacao;
		this.conteudoPublicacao = conteudoPublicacao;
		this.idBlog = idBlog;
	}
	
	public int getIdPublicacao() {
		return idPublicacao;
	}
	public void setIdPublicacao(int idPublicacao) {
		this.idPublicacao = idPublicacao;
	}
	public String getTituloPublicacao() {
		return tituloPublicacao;
	}
	public void setTituloPublicacao(String tituloPublicacao) {
		this.tituloPublicacao = tituloPublicacao;
	}
	public String getCategoriaPublicacao() {
		return categoriaPublicacao;
	}
	public void setCategoriaPublicacao(String categoriaPublicacao) {
		this.categoriaPublicacao = categoriaPublicacao;
	}
	public String getConteudoPublicacao() {
		return conteudoPublicacao;
	}
	public void setConteudoPublicacao(String conteudoPublicacao) {
		this.conteudoPublicacao = conteudoPublicacao;
	}
}
