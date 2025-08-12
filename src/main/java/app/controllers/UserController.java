package app.controllers;

import app.entities.User;
import app.exception.CustomException;
import app.persistence.UserMapper;
import io.javalin.Javalin;
import io.javalin.http.Context;

public class UserController {

    public static void addRoutes(Javalin app) {
        //Start- og loginside
        app.post("index", ctx -> UserController.userLogin(ctx));
        app.get("startPage", ctx -> ctx.render("startPage.html"));


        //Rute til oprettelse af konto
        app.post("/createAccount", ctx -> UserController.createUser(ctx));
        app.get("/createAccount", ctx -> ctx.render("/createAccount.html"));

    }


    public static int createUser(Context ctx) throws CustomException {
        try {

            String username = ctx.formParam("createUsername");
            String password = ctx.formParam("createPassword");

            User user = new User(username, password);

            boolean userExist = UserMapper.userExist(user);
            if (userExist) {
                ctx.attribute("message", "Brugernavn findes allerede");
                ctx.render("createAccount");
                return 0;
            } else {
                int result = UserMapper.addUser(username, password);

                if (result == 1) {
                    ctx.sessionAttribute("currentUser", user);
                    ctx.attribute("message", "Du er nu oprettet");
                    ctx.status(200).render("index.html");
                    return 1;
                } else {
                    ctx.status(400).result("Fejl ved oprettelse");
                    return -1;
                }
            }

        } catch (Exception e) {
            ctx.status(500).result("catchblock i createUser hvis der noget galt med koden: " + e.getMessage());
            return -2;
        }
    }

    public static void userLogin(Context ctx){
        String username = ctx.formParam("username");

        try{

            User user = UserMapper.logIn(username);
            if(user != null){
                ctx.sessionAttribute("currentUser", user);
                ctx.redirect("/startPage");
            } else {
                ctx.attribute("message", "Fejl i brugernavn eller password");
                ctx.render("index");
            }

        } catch (CustomException e){
            ctx.status(500).result("Fejl under login: " + e.getMessage());
        }

    }

}



