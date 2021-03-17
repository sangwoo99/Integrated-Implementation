package com.haeyo.biz.board.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haeyo.biz.board.BoardVO;
import com.haeyo.biz.user.UserVO;

@Repository
public class TogetherBoardDAO {
	@Autowired
	public SqlSessionTemplate sqlSession;
	
	public void insertBoard(BoardVO vo) {
		sqlSession.insert("togetherBoardDAO.insertTogetherBoard", vo);
	}
	
	public void updateBoard(BoardVO vo) {
		System.out.println("TogetherDAO에서 updateBoard 처리");
		System.out.println(vo);
		sqlSession.update("togetherBoardDAO.updateTogetherBoard", vo);
	}
	
	public void deleteBoard(int tNo) {
		sqlSession.delete("togetherBoardDAO.deleteTogetherBoard", tNo);
	}
	
	public TogetherBoardVO getTogetherBoard(int tNo) {
		System.out.println("TogetherDAO에서 getTogetherBoard 처리");
		System.out.println((TogetherBoardVO)sqlSession.selectOne("togetherBoardDAO.selectTogetherBoard", tNo));
		return (TogetherBoardVO)sqlSession.selectOne("togetherBoardDAO.selectTogetherBoard", tNo);
	}
	
	public List<BoardVO> getTogetherBoardList(UserVO userVO) {
		System.out.println("TogetherDAO에서 BoardList 처리");
		System.out.println(sqlSession.selectList("togetherBoardDAO.selectTogetherBoardList", userVO));
		return sqlSession.selectList("togetherBoardDAO.selectTogetherBoardList", userVO); // ListVO를 이용하는 것 같음
	}
	
	//-----------------댓글에 대한 부분--------------------
	public List<TogetherBoardVO> getTogetherBoardReply(int tNo) {
		System.out.println("TogetherDAO에서 getTogetherBoardReply 처리");
		return sqlSession.selectList("togetherBoardDAO.selectReply", tNo);
	}
	
//	public List<TogetherBoardVO> getTogetherBoardReplyOne(int tNo) {
//		System.out.println("TogetherDAO에서 getTogetherBoardReply 처리");
//		return sqlSession.selectList("togetherBoardDAO.selectReply", tNo);
//	}
	
	public TogetherReplyVO insertSelectReply(TogetherReplyVO togetherReplyVO) {
		System.out.println("TogetherBoardDAO insertSelectReply처리");
		int trNo = sqlSession.insert("togetherBoardDAO.insertReply", togetherReplyVO);
		System.out.println("trNo = " + trNo);
		TogetherReplyVO result = sqlSession.selectOne("togetherBoardDAO.selectReplyOne", trNo);
		System.out.println(result);
		return result;
	}
	
	public void deleteReply(int trNo) {
		System.out.println("TogetherBoardDAO deleteReply처리");
		sqlSession.delete("togetherBoardDAO.deleteReply", trNo);
	}
	
}
