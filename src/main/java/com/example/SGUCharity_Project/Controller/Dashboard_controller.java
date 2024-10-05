package com.example.SGUCharity_Project.Controller;

import com.example.SGUCharity_Project.Model.Artical_model;
import com.example.SGUCharity_Project.Model.Articaldetail_model;
import com.example.SGUCharity_Project.Repository.ArticalDetail_Repo;
import com.example.SGUCharity_Project.Repository.Charitycontent_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class Dashboard_controller {
    @Autowired
    Charitycontent_Repo charitycontentRepo;

    @Autowired
    ArticalDetail_Repo articalDetailRepo;

    // Render ra trang dashboard
    @GetMapping("/manager")
    public String dashboard() {
        return "page_admin/Dashboard";
    }

    // Render ra trang quản lý chương trình
    @GetMapping("/dashboard_programmanagement")
    public String programmanagement(Model model) {
        List<Artical_model> charitycontentModelList = charitycontentRepo.findAll();
        model.addAttribute("charitycontentModelLists", charitycontentModelList);
        return "page_admin/ProgramManagement_admin";
    }

    // Render ra trang quản lý nội dung bài viết
    @GetMapping("/dashboard_articlemanagement")
    public String articlemanagemrnt(Model model) {
        List<Articaldetail_model> articaldetailModelList = articalDetailRepo.findAll();
        model.addAttribute("articaldetailModelLists", articaldetailModelList);
        return "page_admin/ArticleManagement_admin";
    }

    @GetMapping("/orders")
    public String orders() {
        return "page_admin/Home_admin";
    }

    // Handle chuc nang insert account
    @PostMapping("/orders")
    public String account_insert(@RequestParam("inputimg") String inputimg, @RequestParam("inputtitle")String inputtitle) {
        Artical_model charitycontentModel = new Artical_model();
        charitycontentModel.setImg(inputimg);
        charitycontentModel.setTitle(inputtitle);
        charitycontentRepo.save(charitycontentModel);
        return "redirect:/orders";
    }
}
