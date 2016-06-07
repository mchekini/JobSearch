package com.needjob.JobSearch;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.needjob.dao.AnnonceDao;
import com.needjob.dao.AnnonceDaoImplementation;
import com.needjob.model.Annonce;
import com.needjob.model.User;

import com.needjob.*;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) { 
		return "index";		
	}
	
	
	@RequestMapping(value = "/Authentification", method = RequestMethod.POST)
	public String Authentification(HttpSession session,Locale locale, Model model, String login, String password) throws NoSuchAlgorithmException { 
		
		 com.needjob.traitements.Authentification auth = new com.needjob.traitements.Authentification();
		 
		 User user = auth.verif_authentification(login, password);
		 if (user==null)
		 {
			 model.addAttribute("erreur", "Login ou mot de passe incorrect");
			 return "home";
		 }
		 else
		 {
			 model.addAttribute("login", user.getPseudo());
			 String type = user.getType();
			 if (type.equals("Annonceur")) return "annonceur";
			 else if (type.equals("Consultant")) return "consultant";
		 }
		 
		 
		 
		return "home";
		
	}
	
	@RequestMapping(value = "/Offres", method = RequestMethod.GET)
	public @ResponseBody List<Annonce> Get_offers() throws NoSuchAlgorithmException, JsonGenerationException, JsonMappingException, IOException { 
		
		
		 System.out.println("requete recu");
		 AnnonceDao annonces = new AnnonceDaoImplementation();		 
		 List<Annonce> liste_annonces = annonces.getAllAnnonces();
         return liste_annonces;
		
	}
	
}
