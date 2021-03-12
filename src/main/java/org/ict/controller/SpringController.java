package org.ict.controller;

import java.util.ArrayList;

import org.ict.domain.BaseVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;


@Controller
// 기본 url(localhost:8282/ 뒤에 spring/모든 패턴 이 추가됨'
@RequestMapping("/spring/*")
public class SpringController {
	
	@RequestMapping("")
	public void base() {
		
		System.out.println("기본 url로 접속했습니다.");
	}
	
	// @RequestMapping은 여러 파라미터를 가집니다.
	// value 파라미터는 필수이고, url 패턴을 기술합니다.
	// method 파라미터는 생략이 가능하고, 처리할 접속방식을 정의합니다.
	// 리턴 자료형이 void인 경우, 주소.jsp파일을 화면에 뿌린다.
	// 경로는 기본주소 이후에 추가로 붙은 주소를 경로로 한다.
	// 접속url : localhost:8181/spring/base
	@RequestMapping(value="/base",
		method= {RequestMethod.GET, RequestMethod.POST})
	public void baseGet() {
		
		System.out.println("base get post");
	}
	
	// GetMapping은 오로지 get방식 접속만 정의할때 사용합니다.
	// 접속url : localhost:8181/spring/baseGet
	@GetMapping("/baseGet")
	public void baseGet2() {
		
		System.out.println("base get!");
	}
	
	// 마찬가지로 PostMapping은 오로지 Post방식 접속만 정의합니다.
	@PostMapping("/basePost")
	public void basePost() {
		
		System.out.println("그냥 접속할 수 없는 POST");
	}
	
	// get방식으로 접속하는 메소드를 하나 만들어주세요.
	// 자율적으로 만들어주세요.
	@GetMapping("/ict")
	public void ict() {
		
		System.out.println("ict 인재개발원 입니다.");
	}
	
	// BaseVO의 멤버변수들을 파라미터로 처리할 수 있는 메소드
	// 메소드의 파라미터 클래스를 선언하면 겟터와 셋터가 있을 때
	// 컨트롤러 내부적으로 파라미터를 객체에게 전달할 수 있다.
	// 단, 이 경우는 클래스의 멤버변수와 파라미터 이름이 일치해야한다.
	// 리턴타입이 Spring인 경우 url주소를 무시하고
	// 곧바로 리턴된문자열.jsp 를 views폴더 하위에 배치해야합니다.
	@GetMapping("/vo")
	public String vo01(BaseVO vo) {
		
		System.out.println("" + vo);
		return "vo01";
	}
	
	// vo02.jsp를 spring폴더 하위에 저장하는 메소드 vo02를
	// 작성해주세요. 내부 코드는 vo01과 일치합니다.
	// 스프링에서는 Model이라는 객체를 이용해 컨트롤러의 데이터를 
	// 뷰(view)로 보내줍니다.
	// 1.메소드의 파라미터 선언부에 추가로 Model객체를 선언합니다.
	// 2. model.addAttribute("보낼이름", "보낼자료"); 구문 작성.
	// 3. .jsp에서는 ${보낸이름} 으로 처리 가능
	@GetMapping("/vo2")
	public String vo02(Model model, BaseVO vo) {
		
		System.out.println("" + vo);
		model.addAttribute("BaseVO", vo);
		return "spring/vo02";
	}
	
	// 참조형 변수는 사실 model.addAttribute를 사용하지 않아도
	// 자동으로 전달을 해 줍니다.
	// 이 때에는 자료형의 맨 앞글자만 소문자로 바꿔서 자동 전달됩니다.
	// 반면 기본형 변수는 자동 전달이 이루어지지 않는데
	// 이 때 model.addAttribute를 쓸 수도 있지만
	// 대신 @ModelAttribute를 써서 전달할 수 있습니다.
	// @ModelAttribute("보낼이름")으로 선언합니다.
	// 파라미터로 기본형 자료 선언시 반드시 자료가 전달되어야합니다.
	@GetMapping("/vo3")
	public String vo03(BaseVO vo,
						@ModelAttribute("num") int num,
						Model model) {
		System.out.println("회원번호 : " + num);
		//model.addAttribute()를 사용해 num도 전달해주세요.
		//model.addAttribute("num", num);
		return "spring/vo03";
	}
	
	// 특정 주소 접속시 redirect를 수행시키고 싶다면
	// return하는 문자열 앞에 redirect: 를 추가해줍니다.
	// url에서 가장 왼쪽에 적는 /는
	// 기본 주소(localhost:8181/)를 의미합니다.
	@GetMapping("/qwer")
	public String redirectTest() {
		System.out.println("/base로 redirect");
		return "redirect:/spring/";
	}
	
	// 파일 업로드 페이지로 연결해주는 메소드
	@GetMapping("/exUpload")
	public void exUpload() {
		System.out.println("/exUpload....");
	}
	
	// 파일은 POST방식으로 전송했기 때문에 @PostMapping 처리
	@PostMapping("/exUploadPost")
	public void exUploadPost(
			ArrayList<MultipartFile> files) {
		files.forEach(file -> {
			System.out.println("-----------------");
			System.out.println("name : " + file.getOriginalFilename());
			System.out.println("size : " + file.getSize());
		});
	}
	
}
