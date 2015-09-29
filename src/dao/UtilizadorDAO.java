package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Utilizador;


public class UtilizadorDAO  extends ConnectionFactory{
	
	Utilizador utilizador = new Utilizador();
	
	
	public void criarUtilizador(Utilizador utilizador) {
		try {
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao
					.prepareStatement("INSERT INTO Utilizador (nome,sobrenome,email,genero,senha,apelido) VALUES(?,?,?,?,?,?);");
			pstm.setString(1, utilizador.getNome());
			pstm.setString(2, utilizador.getSobrenome());
			pstm.setString(3, utilizador.getEmail());
			pstm.setString(4, utilizador.getGenero());
			pstm.setString(5, utilizador.getSenha());
			pstm.setString(6, utilizador.getApelido());
			pstm.execute();
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Utilizador> listarUtilizador() {
		List<Utilizador> lista = new ArrayList<>();
		try {
			Connection conexao = getConexao();
			Statement stm = conexao.createStatement();
			ResultSet rs = stm.executeQuery("Select * from Utilizador");
			while (rs.next()) {
				Utilizador utilizador = new Utilizador();
				utilizador.setId(rs.getInt("id"));
				utilizador.setNome(rs.getString("nome"));
				utilizador.setEmail(rs.getString("email"));
				utilizador.setSenha(rs.getString("senha"));
				utilizador.setApelido(rs.getString("apelido"));
				lista.add(utilizador);
			}
			stm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
		
	public void excluir(String id) {
		try {
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao
					.prepareStatement("Delete from Utilizador where id ="+id);
		
			pstm.execute();
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void editarUtilizador(Utilizador utilizador, String id){
		System.out.println("que doença:"+ id);
		try{
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao.prepareStatement("update Utilizador set nome=?, sobrenome=?, genero=?, senha=?, apelido=? where id=?");
			pstm.setString(1, utilizador.getNome());
			pstm.setString(2, utilizador.getSobrenome());
			pstm.setString(3, utilizador.getGenero());
			pstm.setString(4, utilizador.getSenha());
			pstm.setString(5, utilizador.getApelido());
			pstm.setString(6, id);
			
			pstm.execute();
			pstm.close();
			conexao.close();
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Utilizador listarPerfilUtilizador(String id) {
		Utilizador utilizador = new Utilizador();
		utilizador.setNome("");
		try {
			Connection conexao = getConexao();
			Statement stm = conexao.createStatement();
			ResultSet rs = stm.executeQuery("Select * from Utilizador where id="+id);
			while (rs.next()) {
				utilizador.setId(rs.getInt("id"));
				utilizador.setNome(rs.getString("nome"));
				utilizador.setSobrenome(rs.getString("sobrenome"));
				utilizador.setEmail(rs.getString("email"));
				utilizador.setGenero(rs.getString("genero"));
				utilizador.setSenha(rs.getString("senha"));
				utilizador.setApelido(rs.getString("apelido"));
			}
			System.out.println("listarPerfil ENTRY!");
			stm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return utilizador;
	}
	
}
