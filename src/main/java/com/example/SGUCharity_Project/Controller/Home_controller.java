package com.example.SGUCharity_Project.Controller;

import com.example.SGUCharity_Project.Model.Charitycontent_model;
import com.example.SGUCharity_Project.Repository.Charitycontent_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class Home_controller {
    @Autowired
    private Charitycontent_Repo charitycontentRepo;

    // Render ra trang product
    @GetMapping("/trang-chu")
    public String list_content(Model model) {
        List<Charitycontent_model> charitycontent = charitycontentRepo.findAll();
        model.addAttribute("charitycontent", charitycontent);
        return "page_user/Home";  // Trả về trang Home.html
    }
}
