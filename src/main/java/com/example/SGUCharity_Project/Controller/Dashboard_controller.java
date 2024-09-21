package com.example.SGUCharity_Project.Controller;

import com.example.SGUCharity_Project.Model.Charitycontent_model;
import com.example.SGUCharity_Project.Repository.Charitycontent_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Dashboard_controller {
    @Autowired
    Charitycontent_Repo charitycontentRepo;

    // Render ra trang dashboard
    @GetMapping("/manager")
    public String dashboard() {
        return "page_admin/Dashboard";
    }

    @GetMapping("/orders")
    public String orders() {
        return "page_admin/Home_admin";
    }

    // Handle chuc nang insert account
    @PostMapping("/orders")
    public String account_insert(@RequestParam("inputimg") String inputimg, @RequestParam("inputtitle")String inputtitle) {
        Charitycontent_model charitycontentModel = new Charitycontent_model();
        charitycontentModel.setImg_charitycontent(inputimg);
        charitycontentModel.setTitle_charitycontent(inputtitle);
        charitycontentRepo.save(charitycontentModel);
        return "redirect:/orders";
    }
}
