import controllers.ReimbursementController;
import controllers.SessionController;
import controllers.UserController;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import models.Reimbursement;
import models.User;
import repository.ReimbursementDAO;
import repository.ReimbursementDAOImpl;
import repository.UserDAO;
import repository.UserDAOImpl;
import services.ReimbursementService;
import services.UserService;

import java.util.List;

public class MainDriver {
    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
            config.addStaticFiles("/", Location.CLASSPATH);
        }).start(9000);


        //Javalin app = Javalin.create().start(9000);
        UserController userController = new UserController();
        ReimbursementController reimbursementController = new ReimbursementController();
        SessionController sessionController = new SessionController();
        // :: method reference symbol
        app.post("/user", userController::createUser);
        app.post("/login", sessionController::login);
        app.get("/login", sessionController::checkSession);
        app.delete("/delete", sessionController::logout);
        app.get("/displayReimb/{userId}", reimbursementController::displayAllPastReimbursementsForuser);
        app.get("/displayReimbByStatus/{statusId}", reimbursementController::displayAllReimbursmentsForUserByStatus);
        app.patch("/updateReimb/{reimbId}/{statusId}", reimbursementController::updateReimbursement);
        app.post("/createReimb", reimbursementController::createReimbursement);
        app.get("/displayallReimb", reimbursementController::getAllReimbursements);



        /*ReimbursementDAO reimbursementDAO = new ReimbursementDAOImpl();
        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setStatusId(2);
        reimbursement.setReimbId(1);
        reimbursementDAO.update(reimbursement);*/


        //UserDAO userDAO = new UserDAOImpl();
        //userDAO.createUser(new User("steve123", "pass123","steve","jobs", "steve@gmail",2 ));
        //System.out.println(userDAO.getUserGivenUsername("keerthy-em"));
        //System.out.println(userDAO.createUser(new User("username", "password", "firstname", "lastname", "email", "roleid"););


        /*ReimbursementDAO reimbursementDAO = new ReimbursementDAOImpl();
        Reimbursement reimbursement = new Reimbursement();

        reimbursement.setAmount(100.00);
        reimbursement.setDescription("description");
        reimbursement.setStatusId(2);
        reimbursement.setTypeId(2);
        reimbursement.setAuthorId(4);
        reimbursement.setResolverId(2);
        reimbursementDAO.create(reimbursement);*/

        /*System.out.println(reimbursementDAO.getAllReimbursements().size());
        List<Reimbursement>  lists = reimbursementDAO.getAllReimbursements();
        for (Reimbursement r: lists) {
            System.out.println(r);
        }*/
    /*ReimbursementDAO reimbursementDAO = new ReimbursementDAOImpl();
    reimbursementDAO.update(3, 10);*/


        //ReimbursementDAO reimbursementDAO = new ReimbursementDAOImpl();
        //List<Reimbursement>  lists  = reimbursementDAO.reimbursementGetById(1);
        //List<Reimbursement> reimbystatus = reimbursementDAO.getByStatusId(2);
        //List<Reimbursement> reimbyauthor = reimbursementDAO.reimbursementGetById(3);
        //System.out.println(reimbystatus.size());
        //System.out.println(reimbyauthor.size());
        /*for (int i=0; i<reimbyauthor.size(); i++){
            System.out.println(reimbyauthor.get(i));
        }*/
        /*for (Reimbursement r: reimbystatus){
            System.out.println(r);
        }*/

        //System.out.println(reimbursementDAO.getByStatus(1));//status is showing 0
        //User user;
        //UserService userService = new UserService();
        //System.out.println(userService.validateCredentials("keerthy-em", "pass123"));
        //userService.createUser(new User("janeuser","pass123", "jane", "doe", "jane@gmail", 1));
        //reimbursementDAO.update(new Reimbursement());
        //ReimbursementService reimbursementService = new ReimbursementService();
        //System.out.println(reimbursementService.reimbursementGetById(3));
        //System.out.println(reimbursementService.getByStatus(1));

    }
}
