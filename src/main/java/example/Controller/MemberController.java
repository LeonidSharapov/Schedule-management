package example.Controller;

import example.Controller.Model.Members;
import example.Controller.Repository.MembersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MemberController {
@Autowired
    MembersRepository membersRepository;
@PostMapping("/chek")
    public String chek(@RequestParam int id, Model model){
    List<Members>list= membersRepository.findByAll(id);
    Members members=membersRepository.findById(list.get(0).getId()).orElseThrow(null);
    model.addAttribute("id",id);
    model.addAttribute("name",members.getName());
    model.addAttribute("status", members.getStatus());
    model.addAttribute("password",members.getPassword());

    return "chek";
}
    @PostMapping("/delete-member")
    public String delete(@RequestParam int id,@RequestParam String name,Model model){
        model.addAttribute("name", name);
        model.addAttribute("id",id);

        return "delete";
    }
    @PostMapping("/delete-member2")
    public String delete2(@RequestParam int id){
        List<Members>list= membersRepository.findByAll(id);
    membersRepository.deleteById(list.get(0).getId());
        return "redirect:/list/member";
    }
}
