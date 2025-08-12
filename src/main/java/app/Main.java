package app;

import app.config.SessionConfig;
import app.config.ThymeleafConfig;

import app.controllers.UserController;
import app.persistence.UserMapper;


import app.controllers.WeekController;
import app.persistence.ConnectionPool;
import app.persistence.WeekMapper;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinThymeleaf;

private static final String USER = "postgres";
private static final String PASSWORD = "a20652691a";
private static final String URL = "jdbc:postgresql://207.154.238.209:5432/%s?currentSchema=public";
private static final String DB = "madkalenderen";

private static final ConnectionPool connectionPool = ConnectionPool.getInstance(USER, PASSWORD, URL, DB);



public static void main(String[] args) {
    // Initializing Javalin and Jetty webserver

    Javalin app = Javalin.create(config -> {
        config.staticFiles.add("/public");
        config.jetty.modifyServletContextHandler(handler ->  handler.setSessionHandler(SessionConfig.sessionConfig()));
        config.fileRenderer(new JavalinThymeleaf(ThymeleafConfig.templateEngine()));
    }).start(7070);

    UserMapper.setConnectionPool(connectionPool);

    // Routing
    app.get("/", ctx -> ctx.redirect("/index"));
    app.get("/index", ctx -> ctx.render("index.html"));
    UserController.addRoutes(app);

    WeekMapper.setConnectionPool(connectionPool);

    // Routing

    

    app.post("/addWeek", ctx -> ctx.render("addWeek.html"));


// Formular til at oprette uge
    app.get("/add-week", ctx -> ctx.render("addweek.html"));

// Opret uge (POST)
    app.post("/add-week", ctx -> {
        WeekController controller = new WeekController();
        controller.addWeekToCalender(ctx);
    });



}
