package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.form.SampleForm;


@Controller
@RequestMapping("/lesson")
public class LessonController {

	@GetMapping("/request_test")
    // 返り値をレスポンスとして扱う
    @ResponseBody
    // name ... 名前、 bloodType ... 血液型
    // パラメータ名と仮引数名が同じな場合、@RequestParam String nameのようにパラメータ名の指定を省略
    public String getTest(@RequestParam("name") String name
                          , @RequestParam("bloodType") String bloodType) {
        return "名前: " + name + "<br>血液型: " + bloodType;
	}
	
    // POST通信で/lesson/request_testにリクエストした場合にpostTestを実行
    @PostMapping("/request_test")
    @ResponseBody
    public String postTest(SampleForm sampleForm) {
        return "名前: " + sampleForm.getName() + "<br>血液型: " + sampleForm.getBloodType();
    }
    
    @GetMapping("/form_test")
//    public String formTest(SampleForm sampleForm, Model model) {
//        model.addAttribute("sampleForm", sampleForm);
//        return "lesson/form_test";
//    }
    
     // SampleFormをModel属性にセットするだけであればModelクラスは不要
    public String formTest(@ModelAttribute SampleForm sampleForm) {
        return "lesson/form_test";
    }
}