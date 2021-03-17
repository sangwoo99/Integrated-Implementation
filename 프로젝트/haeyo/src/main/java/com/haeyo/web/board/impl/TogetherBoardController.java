package com.haeyo.web.board.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.haeyo.biz.user.UserVO;
import com.haeyo.biz.board.BoardVO;
import com.haeyo.biz.board.impl.TogetherBoardServiceImpl;
import com.haeyo.biz.board.impl.TogetherBoardVO;
import com.haeyo.biz.board.impl.TogetherMemberVO;
import com.haeyo.biz.board.impl.TogetherReplyVO;

@Controller
public class TogetherBoardController {

	@Autowired
	public TogetherBoardServiceImpl togetherBoardServiceImpl;
	
	@PostMapping("/t_insertBoard.do")
	public String insertBoard(@ModelAttribute TogetherBoardVO togetherboardVO) throws Exception {
		System.out.println("TogetherBoardController에서 insertBoard 작동");
		togetherboardVO = togetherBoardServiceImpl.uploadBoard(togetherboardVO);
		System.out.println(togetherboardVO);
		togetherBoardServiceImpl.insertBoard(togetherboardVO);
		return "redirect:t_getBoardList.do";
	}

	@PostMapping("/t_updateBoard.do")
	public String updateBoard(@ModelAttribute TogetherBoardVO togetherboardVO) throws Exception {
		System.out.println("TogetherBoardController updateBoard처리");
		togetherboardVO = togetherBoardServiceImpl.uploadBoard(togetherboardVO);
		System.out.println(togetherboardVO);
		togetherBoardServiceImpl.updateBoard(togetherboardVO);
		return "redirect:t_getBoardList.do";
	}

	@RequestMapping("/t_deleteBoard.do")
	public String deleteBoard(@RequestParam("tNo") int tNo) {
		togetherBoardServiceImpl.deleteBoard(tNo);
		return "redirect:t_getBoardList.do";
	}

	@RequestMapping(value="/t_getBoard.do", method=RequestMethod.GET)
	public String getBoard(@RequestParam("tNo") int tNo, Model model) {
		model.addAttribute("board",togetherBoardServiceImpl.getBoard(tNo));
		model.addAttribute("ReplyList", togetherBoardServiceImpl.getBoardReply(tNo));
		return "togetherBoard";
	}
	
	//main=>거리외에는 조건 없는 select
	//카테고리별=> t_header='같이출퇴근해요'
	@RequestMapping("/t_getBoardList.do")
	public String getBoardList(Model model, HttpSession session) {
		UserVO userVO = new UserVO();
//		int uNo = session.getAttribute("");
//		userVO.setuNo(uNo);
		userVO.setuNo(10001);
		model.addAttribute("boardList",togetherBoardServiceImpl.getBoardList(userVO));
		return "togetherMain";
	}
	
	@RequestMapping("/t_getWritingBoard.do")
	public String getWritingBoard(Model model) {
		return "togetherInsertBoard";
	}
	
	@RequestMapping("/t_getUpdateBoard.do")
	public String getUpdateBoard(Model model, @RequestParam int tNo) {
		model.addAttribute("Board",togetherBoardServiceImpl.getBoard(tNo));
		return "togetherUpdateBoard";
	}
	
	@RequestMapping("/t_insertSelectReply.do")
	@ResponseBody
	public TogetherReplyVO insertSelectReply(@ModelAttribute TogetherReplyVO togetherReplyVO) {
		System.out.println("TogetherBoardController insertSelectReply처리");
		System.out.println(togetherReplyVO);
		System.out.println(togetherBoardServiceImpl.insertSelectReply(togetherReplyVO));
		return togetherBoardServiceImpl.insertSelectReply(togetherReplyVO);
	}
	
	@RequestMapping("/t_deleteReply.do")
	@ResponseBody
	public List<TogetherBoardVO> deleteReply(@RequestParam int trNo, @RequestParam int tno) {
		System.out.println("TogetherBoardController deleteReply처리");
		System.out.println(togetherBoardServiceImpl.deleteReply(trNo, tno));
		return togetherBoardServiceImpl.deleteReply(trNo, tno);
	}
	
//	@RequestMapping("/t_updateJoinNow.do")
//	public TogetherReplyVO updateJoinNow(@RequestParam("joinData") TogetherMemberVO togetherMemberVO) {
//		System.out.println("TogetherBoardController insertSelectReply처리");
//		System.out.println(togetherBoardServiceImpl.insertSelectReply(togetherReplyVO));
//		return togetherBoardServiceImpl.insertSelectReply(togetherReplyVO);
//	}
}
