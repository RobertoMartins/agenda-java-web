package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

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
	public void inserirContato(JavaBeans contato) {
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
}
