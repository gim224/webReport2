package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Subject;

@Repository
public class SubjectDAO {
	private JdbcTemplate jdbcTemplateObject;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	// public int getRowCount() {
	// String sqlStatement = "select count(*) from register";
	// return jdbcTemplateObject.queryForObject(sqlStatement, Integer.class);
	// }

	public List<Subject> getGradePerPart() {
		String sqlStatement = "select part,sum(grade) from register group by part";

		return jdbcTemplateObject.query(sqlStatement, new RowMapper<Subject>() {

			@Override
			public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Subject subject = new Subject();
				subject.setPart(rs.getString("part"));
				subject.setGrade(rs.getInt("sum(grade)"));
				return subject;
			}

		});

	}

	// public Subject getSubject(String name) {
	// String sqlStatement = "select * from register where name=?";
	//
	// return jdbcTemplateObject.queryForObject(sqlStatement, new Object[] {
	// name }, new RowMapper<Subject>() {
	//
	// @Override
	// public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
	// // TODO Auto-generated method stub
	// Subject subject = new Subject();
	// subject.setYear(rs.getInt("year"));
	// subject.setSemester(rs.getInt("semester"));
	// subject.setId(rs.getString("id"));
	// subject.setName(rs.getString("name"));
	// subject.setPart(rs.getString("part"));
	// subject.setGrade(rs.getInt("grade"));
	// return subject;
	// }
	//
	// });
	// }

	// public List<Subject> getSubjects() {
	// String sqlStatement = "select * from register";
	//
	// return jdbcTemplateObject.query(sqlStatement, new RowMapper<Subject>() {
	//
	// @Override
	// public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
	// // TODO Auto-generated method stub
	// Subject subject = new Subject();
	// subject.setYear(rs.getInt("year"));
	// subject.setSemester(rs.getInt("semester"));
	// subject.setId(rs.getString("id"));
	// subject.setName(rs.getString("name"));
	// subject.setPart(rs.getString("part"));
	// subject.setGrade(rs.getInt("grade"));
	// return subject;
	// }
	//
	// });
	// }

	public List<Subject> getGradePerYearSemester() {
		String sqlStatement = "select year, semester, sum(grade) from register group by year, semester";

		return jdbcTemplateObject.query(sqlStatement, new RowMapper<Subject>() {

			@Override
			public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Subject Subject = new Subject();
				Subject.setYear(rs.getInt("year"));
				Subject.setSemester(rs.getInt("semester"));
				Subject.setGrade(rs.getInt("sum(grade)"));
				return Subject;
			}

		});
	}

	public List<Subject> getSubjectName(int year, int semester) {
		String sqlStatement = "select name from register where year=? and semester=? ";

		return jdbcTemplateObject.query(sqlStatement, new Object[] { year, semester }, new RowMapper<Subject>() {

			@Override
			public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Subject subject = new Subject();

				subject.setName(rs.getString("name"));

				return subject;
			}

		});

	}

	public int getSumGrade() {
		String sqlStatement = "select sum(grade) from register";

		return jdbcTemplateObject.queryForObject(sqlStatement, Integer.class);

	}

	public boolean insert(Subject subject) {
		String sqlStatement = "insert into register (year, semester, id, name, part, grade) values	(2017,1,?,?,?,?)";

		
		if(isContain(subject.getId()))
			return false;
		String id = subject.getId();
		String name = subject.getName();
		String part = subject.getPart();
		int grade = subject.getGrade();

		return (jdbcTemplateObject.update(sqlStatement, new Object[] { id, name, part, grade }) == 1);
	}

	private boolean isContain(String id) {
		String sqlStatement = "select count(id) from register where id=?";

		int c = jdbcTemplateObject.queryForObject(sqlStatement, new Object[] { id }, Integer.class);
		if (c<1)
			return false;
		else
			return true;

	}

	public List<Subject> get2017Register() {
		String sqlStatement = "select id, name, part, grade from register where year=2017 and semester=1";

		return jdbcTemplateObject.query(sqlStatement, new RowMapper<Subject>() {

			@Override
			public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Subject subject = new Subject();
				subject.setId(rs.getString("id"));
				subject.setName(rs.getString("name"));
				subject.setPart(rs.getString("part"));
				subject.setGrade(rs.getInt("grade"));
				return subject;
			}
		});

	}

	// public boolean update(Subject subject) {
	// String sqlStatement = "update register set name=?, email=?, text=? where
	// id=?";
	// int id = subject.getId();
	// String name = subject.getName();
	// String email = subject.getEmail();
	// String text = subject.getText();
	// return (jdbcTemplateObject.update(sqlStatement, new Object[] { name,
	// email, text, id }) == 1);
	// }
	//
	// public boolean delete(int id) {
	// String sqlStatement = "delete from register where id=?";
	//
	// return (jdbcTemplateObject.update(sqlStatement, new Object[] { id }) ==
	// 1);
	// }
}
