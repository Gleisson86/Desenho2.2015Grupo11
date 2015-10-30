package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;

import model.Comentario;
import model.Publicacao;
import model.Utilizador;

public class ComentarioDAO extends ConnectionFactory{
	
	Comentario comentario = new Comentario();
	Utilizador utilizador = new Utilizador();
	Publicacao publicacao = new Publicacao();
	
	Date agora = new Date();
	java.sql.Date sqlDate = new java.sql.Date(agora.getTime());
	
	public void criarComentario(Comentario comentario, Utilizador utilizador, int idPublicacao){
		try{
			
			
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao.prepareStatement("INSERT INTO Comentario (conteudoComentario, "
					+ "dataCriacaoComentario, idUtilizador, idPublicacao) VALUES (?,?,?,?);");
			pstm.setString(1, comentario.getConteudoComentario());
			pstm.setDate(2, sqlDate);
			pstm.setInt(3, utilizador.getId());
			pstm.setInt(4, idPublicacao);
			
			pstm.execute();
			pstm.close();
			conexao.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
		
}