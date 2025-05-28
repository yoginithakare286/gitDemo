package com.yts.revaux.ntQuote.web.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NTQuotePageController {

	@GetMapping("/ntquote")
	public String index() {
		
		return "nt";
	}	

    @GetMapping("/ntQuoteList")
    public String getNtQuoteDatatable() {
        //return "ntquoteui/ntquote";
    	System.out.println("ntQuoteList");
    	return "ntquoteui/NTQuoteList";
    }
    
    @GetMapping("/ntQuoteListMainPage")
    public String getNtQuoteListMainPage() {
    	System.out.println("nt Quote Detailed Screen");
  //   return "ntquoteui/NtQuoteListMainPage"; 
    	//return "ntquoteui/index2"; 
    	return "ntquoteui/NTQuoteList"; 
    } 
    
	/* Nt Quote */
    @GetMapping("/ntQuoteDetailedScreen")
    public String getQuoteDetailScreen() {
        System.out.println("nt Quote Detailed Screen");
       //return "ntquoteui/dummy2forupdate"; 
       // return "ntquoteui/ntQuoteDetailedScreen"; 
       return "ntquoteui/latestNTQuoteDetailsScreenData";
      // return "ntquoteui/Latest_Mar3_For_Fragment";
    }

	
}
