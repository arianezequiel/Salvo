package com.accenture.salvo;

import org.springframework.web.bind.annotation.RequestMapping;

public class SalvoControler
{
        @RequestMapping("/greeting")
        public String greeting(@RequestParam("name") String name, Model model) {
            model.addAttribute("name", name);
            return "greeting";
        }
    }
}
