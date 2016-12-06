package br.com.tiantenado.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.tiantenado.model.Curso;

public class CursosDao {
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public List<Curso> getAll(){
		List<Curso> cursos = new ArrayList<Curso>();
		Connection c = null;
		
		try {
			String sql = "SELECT CD_CURSO, NM_CURSO, DS_CURSO, DT_CURSO, CD_PROFESSOR, CD_MODULO FROM TB_CURSO WHERE CD_MODULO = (SELECT MAX(CD_MODULO) FROM TB_CURSO)";
			c = dataSource.getConnection();
			PreparedStatement stmt = c.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Curso curso = new Curso();
				curso.setCdCurso(rs.getLong("CD_CURSO"));
			}
			
		} catch (SQLException e) {
			System.out.println();
			e.printStackTrace();
		}
		
		
		return cursos;
	}
}
