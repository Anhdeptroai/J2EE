package com.example.SGUCharity_Project.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DonationContext_controller {
    @GetMapping("/chuong-trinh")
    public String donationcontext() {
        return "page_user/DonationContext";
    }
}
