package example.Controller;

import com.sun.deploy.panel.JreTableModel;
import example.Controller.Model.Work;
import example.Controller.Repository.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class WorkRegistcontroller {
   @Autowired
   WorkRepository workRepository;
	@GetMapping("/list/registWork")
	public String regist() {
		return "registWork";
	}
	@PostMapping("/list/registWork")
	public String registAdd(@RequestParam String startTime1, @RequestParam String endTime1,@RequestParam String info1,
			@RequestParam String end1, @RequestParam String coment1, @RequestParam String startTime2,
			@RequestParam String endTime2, @RequestParam String info2, @RequestParam String end2,
							@RequestParam String coment2, HttpSession session) {
           Work work = workRepository.findById((Long)session.getAttribute("workid")).orElseThrow(null);
           work.setComents(coment1);
           work.setComents2(coment2);
           work.setsTime(startTime1);
           work.setsTime2(startTime2);
           work.setfTime(endTime1);
           work.setfTime2(endTime2);
           work.setNaiyo(info1);
           work.setNaiyo2(info2);
           work.setWork(end1);
           work.setWork2(end2);

           workRepository.save(work);
		return"redirect:/list";
	}
}

