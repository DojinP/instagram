package com.multi.instagram.board;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.stereotype.Repository;

@Repository("BoardDAO")
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	JdbcTemplate template;

	@Override
	public int insertBoard(BoardDTO board) {
		String sql = "insert into board_table values(null,?,?,sysdate())";
		return template.update(sql, board.getWriterId(), board.getBoardContent());
	}

	@Override
	public int insertFile(List<BoardFileDTO> boardfiledtolist) {
		String sql = "insert into content_table values (last_insert_id(), ?, ?, ?)";
		template.batchUpdate(sql, boardfiledtolist, boardfiledtolist.size(),
				new ParameterizedPreparedStatementSetter<BoardFileDTO>() {

					@Override
					public void setValues(PreparedStatement ps, BoardFileDTO boardfiledto) throws SQLException {
						ps.setString(1, boardfiledto.getOriginalFilename());
						ps.setString(2, boardfiledto.getStoreFilename());
						ps.setString(3, boardfiledto.getBoardImageFileno());
					}
				});
		return 0;
	}

	// 김혜원 변경
	@Override
	public List<BoardDTO> selectBoard() {
		return template.query(
				"select b.*,(select count(*) from like_Table l where l.board_id= b.board_id ) as like_count from board_Table b;",
				new BoardRowMapper());
	}

	// 김혜원 추가
	@Override
	public List<BoardFileDTO> selectLikeFile(int boardId) {
		String sql = "select * from content_table where board_id = ?";
		return template.query(sql, new Object[] { boardId }, new BoardFileRowMapper());
	}

	@Override
	public List<BoardFileDTO> selectFile() {
		return template.query(
				"select content.* from board_table as board,"
						+ " content_table as content where board.board_id = content.board_id",
				new BoardFileRowMapper());
	}

	@Override
	public BoardUploadDTO readBoard(String boardId, String writerId) {
		String sql = "select b.board_id, b.board_content, b.board_timestamp, f.storeFilename, m.member_nickname "
				+ "from board_table as b, content_table as f, member_table as m "
				+ "where b.board_id = f.board_id and b.writer_id = m.member_id and b.board_id = ? and m.member_id = ?";

		return template.queryForObject(sql, new Object[] { boardId, writerId }, new BoardUploadRowMapper());
	}

	@Override
	public int updateBoard(String boardContent, String boardId) {
		String sql = "update board_table set board_content=?, board_timestamp=sysdate() where board_id= ?";
		return template.update(sql, boardContent, boardId);
	}

	@Override
	public int deleteBoard(String boardId) {
		return template.update("delete from board_table where board_id=?", boardId);
	}

	@Override
	public int deleteBoardFile(String boardId) {
		return template.update("delete from content_table where board_id=?", boardId);
	}

}
