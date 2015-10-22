package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.plaf.synth.SynthScrollBarUI;

import model.Blog;
import model.Publicacao;
import model.Utilizador;

public class PublicacaoDAO extends ConnectionFactory{

	Publicacao publicacao = new Publicacao();
	Blog blog = new Blog();
	
	
	public void criarPublicacao(Publicacao publicacao, Blog blog){
		try{
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao.
					prepareStatement("INSERT INTO Publicacao (tituloPublicacao, categoriaPublicacao, "
							+ "conteudoPublicacao, idBlog) VALUES (?,?,?,?)");
			pstm.setString(1, publicacao.getTituloPublicacao());
			pstm.setString(2, publicacao.getCategoriaPublicacao());
			pstm.setString(3, publicacao.getConteudoPublicacao());
			pstm.setInt(4, blog.getIdBlog());
			pstm.execute();
			pstm.close();
			conexao.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void editarPublicacao(Publicacao publicacao, String idPublicacao){
		try{
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao.prepareStatement("update Publicacao set tituloPublicacao=?, "
					+ "categoriaPublicacao=?, conteudoPublicacao=? where idPublicacao=?");
			pstm.setString(1, publicacao.getTituloPublicacao());
			pstm.setString(2, publicacao.getCategoriaPublicacao());
			pstm.setString(3, publicacao.getConteudoPublicacao());
			
			pstm.setString(4, idPublicacao);
			
			pstm.execute();
			pstm.close();
			conexao.close();
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Publicacao listarCorpoPublicacao(String idPublicacao) {
		Publicacao publicacao = new Publicacao();
		publicacao.setTituloPublicacao("");
		try {
			Connection conexao = getConexao();
			Statement stm = conexao.createStatement();
			ResultSet rs = stm.executeQuery("Select * from Publicacao where idPublicacao="+idPublicacao);
			while (rs.next()) {
				publicacao.setIdPublicacao(rs.getInt("idPublicacao"));
				publicacao.setTituloPublicacao(rs.getString("tituloPublicacao"));
				publicacao.setCategoriaPublicacao(rs.getString("categoriaPublicacao"));
				publicacao.setConteudoPublicacao(rs.getString("conteudoPublicacao"));
			}
			stm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return publicacao;
	}
	
	public void excluirPublicacao(String idPublicacao){
		try{
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao.prepareStatement("Delete from Publicacao where idPublicacao =" +idPublicacao);
			pstm.execute();
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
