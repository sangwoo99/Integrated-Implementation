
package com.haeyo.biz.board.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.haeyo.biz.board.BoardService;
import com.haeyo.biz.board.BoardVO;
import com.haeyo.biz.user.UserVO;

@Service("TogetherBoardService")
public class TogetherBoardServiceImpl {

	@Autowired
	public TogetherBoardDAO togetherBoardDAO;
	
	@Autowired
	HttpSession httpSession;
	
	public void insertBoard(BoardVO boardVO) {
		togetherBoardDAO.insertBoard(boardVO);
	}

	public void updateBoard(BoardVO boardVO) {
		togetherBoardDAO.updateBoard(boardVO);
	}

	public void deleteBoard(int tNo) {
		togetherBoardDAO.deleteBoard(tNo);

	}

	public TogetherBoardVO getBoard(int tNo) {
		System.out.println("TogetherBoardService에서 getBoard 처리");
		return togetherBoardDAO.getTogetherBoard(tNo);
	}
	
	public List<TogetherBoardVO> getBoardReply(int tNo) {
		System.out.println("TogetherBoardService에서 getBoardReply 처리");
		return togetherBoardDAO.getTogetherBoardReply(tNo);
	}

	public List<BoardVO> getBoardList(UserVO userVO) {
		System.out.println("TogetherBoardService에서 boarList 처리");
		return togetherBoardDAO.getTogetherBoardList(userVO);
	}

	public TogetherBoardVO uploadBoard(TogetherBoardVO togetherBoardVO) throws Exception {
		MultipartFile uploadFile = togetherBoardVO.getUploadFile(); //파일 업로드 객체 생성
		System.out.println("uploadBoard() 처리 중");
		if(!uploadFile.isEmpty()) {
			String tPic = uploadFile.getOriginalFilename();
			String rootPath = httpSession.getServletContext().getRealPath("/");
			String attachPath ="/WEB-INF/boardImages/";
			System.out.println(rootPath+attachPath+tPic);
			uploadFile.transferTo(new File(rootPath+attachPath+tPic)); //해당 경로에 받은 이름의 파일을 만들어 저장
			togetherBoardVO.settPic(tPic);
		}
		return togetherBoardVO;
	}
	
	public TogetherReplyVO insertSelectReply(TogetherReplyVO togetherReplyVO) {
		System.out.println("TogetherBoardServiceImpl insertSelectReply처리");
		return togetherBoardDAO.insertSelectReply(togetherReplyVO);
	}
	
	public List<TogetherBoardVO> deleteReply(int trNo, int tno) {
		System.out.println("TogetherBoardServiceImpl deleteReply처리");
		togetherBoardDAO.deleteReply(trNo);
		return togetherBoardDAO.getTogetherBoardReply(tno);
	}
}
