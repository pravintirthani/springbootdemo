package com.demo.company;



import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.demo.ErrorDetails;
import com.demo.NotFoundException;

@ControllerAdvice
@RestController
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@RequestMapping(method=RequestMethod.GET,value="/company")
	public ModelAndView get() {
		List<String> list=companyService.findAll();	
		ModelAndView modelAndView = new ModelAndView("views/company/view");
	    modelAndView.addObject("companyDetail", list);
	    return modelAndView;		
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/raw-company/")
	public List<Company> getRaw() {
		return companyService.findAll();	    
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/company/save")
	public ResponseEntity<Void> save(@Valid @RequestBody Company company) {
		Company companyResponseData =companyService.save(company);;

	    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
	        .buildAndExpand(companyResponseData.getId()).toUri();

	    return ResponseEntity.created(location).build();
	}	
	
	@GetMapping("/company/{id}")
	  public Resource<Company> retrieveCompany(@PathVariable long id) {
	    Optional<Company> company = companyService.findById(id);
	   System.out.println(company.isPresent());
	    if (!company.isPresent()) {
	      throw new NotFoundException("id-" + id);
	    }  
	    Resource<Company> resource = new Resource<Company>(company.get());
	    ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveCompany(id));	    
	    resource.add(linkTo.withRel("all-companys"));

	    return resource;
	  }
}
