package services;

import models.Reimbursement;
import repository.ReimbursementDAO;
import repository.ReimbursementDAOImpl;

import java.util.List;

public class ReimbursementService {
    private ReimbursementDAO reimbursementDAO;
    public ReimbursementService(){
        this.reimbursementDAO = new ReimbursementDAOImpl();
    }

    public ReimbursementService(ReimbursementDAO reimbursementDAO){
        this.reimbursementDAO = reimbursementDAO;
    }


    public List<Reimbursement> reimbursementsGetById(Integer authorId){
        return this.reimbursementDAO.reimbursementGetById(authorId);
    }

    public List<Reimbursement> getByStatusId(Integer statusId) {
        return this.reimbursementDAO.getByStatusId(statusId);
    }

    public void updateReimbursement(Reimbursement unprocessedReimbursement) {
        this.reimbursementDAO.update(unprocessedReimbursement);

    }

    public List<Reimbursement> getAllReimbursements() {
        return this.reimbursementDAO.getAllReimbursements();
    }

    public void createReimbursement(Reimbursement reimbursement) {
        this.reimbursementDAO.create(reimbursement);
    }

}

