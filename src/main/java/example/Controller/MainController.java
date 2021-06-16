package example.Controller;

import example.Controller.Model.Members;
import example.Controller.Model.Work;
import example.Controller.Repository.MembersRepository;
import example.Controller.Repository.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    MembersRepository membersRepository;
    @Autowired
    WorkRepository workRepository;
    @GetMapping("/")
    public  String main( Model model){
        return "Login";
    }


    @PostMapping("/")
    public String add(HttpSession session,@RequestParam int login,@RequestParam String pass,Model model){
    	try {
        session.setAttribute("time", LocalDate.now());
        List<Members> list=membersRepository.findByAll(login);
        if(list.get(0).getPassword().equals(pass)) {
        	session.setAttribute("name",list.get(0).getName());
        	session.setAttribute("status",list.get(0).getStatus());
            session.setAttribute("id",list.get(0).getUserId());

            return "redirect:/list";
        }else {
        	return "/LoginError";
        }
    	}catch(Exception e) {
    		return "/LoginError";
    	}
    }


    @GetMapping("/list")
    public  String List(HttpSession session,Model model){
    	if(session.getAttribute("id")==null){
    	  return "LoginError2";
       }
         model.addAttribute("timeNow", session.getAttribute("time"));
         String date=String.valueOf(session.getAttribute("time"));
         List<Work> list =workRepository.findByTime((int)session.getAttribute("id"),date);
            session.setAttribute("sTime"," ");
        	session.setAttribute("sTime2"," ");
        	session.setAttribute("fTime"," ");
        	session.setAttribute("fTime2"," ");
        	session.setAttribute("naiyo"," ");
        	session.setAttribute("naiyo2"," ");
        	session.setAttribute("work"," ");
        	session.setAttribute("work2"," ");
        	session.setAttribute("coments"," ");
        	session.setAttribute("coments2"," ");

         try {
        	 list.get(0).getId();
        	 session.setAttribute("sTime",list.get(0).getsTime());
           	session.setAttribute("sTime2",list.get(0).getsTime2());
           	session.setAttribute("fTime",list.get(0).getfTime());
           	session.setAttribute("fTime2",list.get(0).getfTime2());
           	session.setAttribute("naiyo",list.get(0).getNaiyo());
           	session.setAttribute("naiyo2",list.get(0).getNaiyo2());
           	session.setAttribute("work",list.get(0).getWork());
           	session.setAttribute("work2",list.get(0).getWork2());
           	session.setAttribute("coments",list.get(0).getComents());
           	session.setAttribute("coments2",list.get(0).getComents2()); //チェック
         }catch(Exception e){
         Work work=new Work(date,(int)session.getAttribute("id"));
         workRepository.save(work);
         return"redirect:/list";
         }
        session.setAttribute("workid",list.get(0).getId());
         session.setAttribute("dbId",list.get(0).getId());
        return "list";
    }


    @PostMapping("/list")
    public  String time(@RequestParam String chek,HttpSession session,Model model ){
        session.setAttribute("time",chek);
        return "redirect:/list";
    }
    @GetMapping("/list/member")
    public  String member(HttpSession session,Model model ){
    	if(session.getAttribute("id")==null || session.getAttribute("id").equals("0") )
    	{
    		   return "LoginError2";

    	}else if(session.getAttribute("status").equals("member")){

    		return"NoAccess";
    	}
    	Iterable<Members> members = membersRepository.findAll();
        model.addAttribute("members",members);
        return "member";
    }


    @PostMapping("/logout")
    public  String logout(HttpSession session,Model model ){
         session.invalidate();
        return "redirect:/";
    }


    @GetMapping("/list/member/add")
    public String add(){
        return "add";
    }


    @PostMapping("/list/member/add/newMember")
    public String add(@RequestParam int id,@RequestParam String name,@RequestParam String status,@RequestParam String pass){
        Members members =new Members(id,name,status,pass);
        try {
            membersRepository.save(members);
            return "redirect:/list";
        }catch (Exception e ){
            return "IdError";

        }
    }
    }

