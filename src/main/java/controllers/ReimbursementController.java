package controllers;

import io.javalin.http.Context;
import models.JsonResponse;
import models.Reimbursement;
import services.ReimbursementService;

import java.util.Date;
import java.util.List;

public class ReimbursementController {
    ReimbursementService reimbursementService;

    public ReimbursementController() {
        this.reimbursementService = new ReimbursementService();
    }

    public ReimbursementController(ReimbursementService reimbursementService){
        this.reimbursementService = reimbursementService;
    }

    public void displayAllPastReimbursementsForuser(Context context){
        Integer userId = Integer.parseInt(context.pathParam("userId"));

        List<Reimbursement> reimbursementsforuser = reimbursementService.reimbursementsGetById(userId);
        context.json(new JsonResponse(true, "listing all reimbursements for user", reimbursementsforuser));

    }

    public void displayAllReimbursmentsForUserByStatus(Context context) {
        Integer statusId = Integer.parseInt(context.pathParam("statusId"));

        List<Reimbursement> reimbursement = reimbursementService.getByStatusId(statusId);
        context.json(new JsonResponse(true, "listing all reimbursements for user by status", reimbursement));
    }

    public void updateReimbursement(Context context) {
        Integer reimbId = Integer.parseInt(context.pathParam("reimbId"));
        Integer statusId = Integer.parseInt(context.pathParam("statusId"));
        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setReimbId(reimbId);
        reimbursement.setStatusId(statusId);

        reimbursementService.updateReimbursement(reimbursement);
        context.json(new JsonResponse(true, "reimbursement update if it exist", null));
    }

    public void createReimbursement(Context context){
        JsonResponse jsonResponse;
        Reimbursement reimbursement = context.bodyAsClass(Reimbursement.class);
        reimbursementService.createReimbursement(reimbursement);
        context.json(new JsonResponse(true, "reimbursement has been created"+ reimbursement.getAuthorId(), null));

    }

    public void getAllReimbursements(Context context){

        context.json(new JsonResponse(true, "all Reimbursements rendered", reimbursementService.getAllReimbursements()));
    }




}
