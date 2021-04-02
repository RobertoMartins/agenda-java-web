package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {

	/* MODULO DE CONEXAO */

	// PARAMETROS DE CONEXÃO
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost/dbagenda?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "";

	// METODOS DE CONEXAO
	private Connection conectar() {
		Connection con = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/** CRUD CREATE **/
	public void inserirContato(ContatoBean contato) {
		String queryCreate = "insert into contatos (nome, fone, email) values (?,?,?)";
		try {
			// abrir a conexao
			Connection con = conectar();

			// Prepara a query para a execução no banco de dados
			PreparedStatement pst = con.prepareStatement(queryCreate);

			// substituir os paramentros pelo conteudo das variaveis JavaBeans

			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());

			// Executar a query
			pst.executeUpdate();

			// Encerrar a conexao com o BD
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/** CRUD READ **/

	public ArrayList<ContatoBean> listarContatos() {

		ArrayList<ContatoBean> contatos = new ArrayList<>();
		String query = "select *from contatos order by nome";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				// variaveis de apoio que recebem os dados do banco.
				String idcon = rs.getString(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);

				// populando o arraylist
				contatos.add(new ContatoBean(idcon, nome, fone, email));
			}
			con.close();
			return contatos;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	/* CRUDE UPDATE */

	// selecionar contato
	public void selecionarContato(ContatoBean contato) {
		String query = " select * from contatos where idcon=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, contato.getIdcon());
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				contato.setIdcon(rs.getString(1));
				contato.setNome(rs.getString(2));
				contato.setFone(rs.getString(3));
				contato.setEmail(rs.getString(4));
			}

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void alterarContato(ContatoBean contato) {
		String update = "update contatos set nome=?, fone=?, email=? where idcon=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(update);
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			pst.setString(4, contato.getIdcon());
			
			pst.executeUpdate();
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void deletarContato(ContatoBean contato) {
		String delete = "delete from contatos where idcon=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, contato.getIdcon());
			pst.executeUpdate();
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
