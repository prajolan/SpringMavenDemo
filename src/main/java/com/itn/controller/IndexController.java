/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itn.controller;

import com.itn.Entities.Document;
import com.itn.Entities.FileBucket;
import com.itn.Entities.UserProfile;
import com.itn.Entities.Users;
import com.itn.excelDao.ExcelView;
import com.itn.excelDao.PdfView;
import com.itn.services.DocumentService;
import com.itn.services.UserProfileService;
import com.itn.services.UserService;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Hp
 */
@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserProfileService userProfileService;

    @Autowired
    private DocumentService documentService;

    @RequestMapping("/prajolan")
    @ResponseBody //ResponseBody does not reload the whole page but only keeps the text in the page
    public String output() {
        return "Hello There";
    }
//    __________________________________AngularTest___________________________________________________

    @RequestMapping({"/", "/home1"})
    public String loadAng() {
        return "angularForm";
    }

    //    _____________________________________________________________________________________
    @RequestMapping(value = "/new")
    public String loadPage(ModelMap mp) {
        mp.addAttribute("message", "Hello there");
        mp.addAttribute("user", new Users());
        return "registration";

    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String submitForm(@ModelAttribute Users user, ModelMap mp) {
        userService.save(user);
        mp.addAttribute("users", userService.findAll());
        return "list";

    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String displayForm(ModelMap mp) {
        mp.addAttribute("users", userService.findAll());

        return null;

    }

    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public String statusForm(ModelMap mp) {
        mp.addAttribute("users", userService.findAll());
        System.out.println("This will load status page");

        return null;
//How is this page loading status page when return is null?
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteForm(@RequestParam long id, ModelMap mp) {
        userService.deleteById(id);
        mp.addAttribute("users", userService.findAll());// Do not need this function when you use redirect function

        return "list";

    }

    @RequestMapping(value = "/edit-{userid}", method = RequestMethod.GET)
    public String editUser(ModelMap mp, @PathVariable long userid) {
        Users user = userService.findById(userid);
        mp.addAttribute("user", user);
        mp.addAttribute("edit", true);
        return "registration";
    }

    @RequestMapping(value = "/status-{userid}", method = RequestMethod.GET)
    public String addStatus(ModelMap mp, @PathVariable long userid) {
        System.out.println("Status Printed");
        Users user = userService.findById(userid);
        mp.addAttribute("user", user);
        //mp.addAttribute("status", true);
        return "addStatus";
    }

    @RequestMapping(value = "/edit-{userid}", method = RequestMethod.POST)
    public String editUser(@ModelAttribute Users user, ModelMap mp) {
        userService.update(user);

        return "redirect:list";
    }

    @RequestMapping(value = "/add-document-{userid}")
    public String uploadFile(ModelMap mp, @PathVariable long userid) {
        mp.addAttribute("filebucket", new FileBucket());
        mp.addAttribute("document", new Document());
        mp.addAttribute("user", userService.findById(userid));
        mp.addAttribute("documents", documentService.retriveByUserId(userid));
        return "ManageDocument";
    }

    @RequestMapping(value = "/add-document-{userid}", method = RequestMethod.POST)
    public String uploadFile(ModelMap mp, @PathVariable long userid, @ModelAttribute FileBucket filebucket) throws IOException {
        Users user = userService.findById(userid);
        Document document = new Document();
        document.setFileName(filebucket.getFile().getOriginalFilename());
        document.setType(filebucket.getFile().getContentType());
        document.setDescription(filebucket.getDescription());
        document.setContent(filebucket.getFile().getBytes());
        document.setUser(user);
        System.out.println("size of a file=" + filebucket.getFile().getSize());

        documentService.saveDocument(document);

        mp.addAttribute("filebucket", new FileBucket());
        mp.addAttribute("document", new Document());
        mp.addAttribute("user", userService.findById(userid));
        return "redirect:add-document-" + userid;
    }

    @RequestMapping(value = "/download-document-{id}", method = RequestMethod.GET)
    public String downloadDcoument(@PathVariable long id, ModelMap mp, HttpServletResponse response) throws IOException {
        Document document = documentService.retriveByDocumentId(id);
        System.out.println("document id" + document.getId());

        response.setContentType(document.getType());
        response.setContentLength(document.getContent().length);
        // response.setHeader("Content-Disposition", "attachment; filename=\"" + document.getName() + "\"");
        FileCopyUtils.copy(document.getContent(), response.getOutputStream());
        System.out.println("download complete vayo");
        return "redirect:/add-document-" + document.getUser().getId();

    }

    @RequestMapping(value = "/delete-document-{id}", method = RequestMethod.GET)
    public String deleteDocument(@PathVariable long id) {
        Document document = documentService.retriveByDocumentId(id);
        documentService.deleteDocument(document);
        return "redirect:/add-document-" + document.getUser().getId();
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    //When you type admin it directly goes to login page, this is inbuilt function by spring
    public String adminPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());//This only gives the username so it can compare for sercituy
        return "welcome";
    }

    @RequestMapping(value = "/dba", method = RequestMethod.GET)
    //When you type admin it directly goes to login page, this is inbuilt function by spring
    public String dbaPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "welcome";
    }

    @RequestMapping(value = "/db", method = RequestMethod.GET)
    //When you type admin it directly goes to login page, this is inbuilt function by spring
    public String dbPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }

    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "accessDenied";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        model.addAttribute("greeting", "Hi, Welcome to mysite. ");
        return "welcome";
    }

//  -----------  APACHE POI or API for excel conversion starts here----------------
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public String downloadData(ModelMap mp) {
        return "downloadData";
    }

    @RequestMapping(value = "/download-{file}", method = RequestMethod.GET)
    //We do not need ModelMap in this method since we are not loading any jsp page
    public ModelAndView downloadExcel(@PathVariable String file) {
        List<Users> allUsers = userService.findAll();
        System.out.println(allUsers.size());
        if (file.equals("excel")) {
            return new ModelAndView(new ExcelView(), "allUsers", allUsers);
        }
        return new ModelAndView(new PdfView(),"allUsers", allUsers);
    }
    //  -----------  APACHE POI or API for excel conversion ends here----------------

    private String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

    //Usued for enum classes to pull all the options of UserProfile
    @ModelAttribute("roles")
    public List<UserProfile> initializeProfiles() {
        return userProfileService.findAll();
    }

}
