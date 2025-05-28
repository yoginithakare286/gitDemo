package com.yts.revaux.admin.web.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

	@GetMapping("/admin")
	public String index() {
		
		/* return "admin"; */
		return "ntquoteui/NTQuoteList"; 
	}
	
	
	 @GetMapping("/buyerlogin")
	    public String getBuyerLogin() {
	       
	    	System.out.println("/buyerlogin =======calledd=======");
	    	 
	        
	        return "YT_UI_WORK/YT_UI_WORK/sign-in-dynamic";
	    }
	
}
