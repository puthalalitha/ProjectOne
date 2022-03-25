package repository;

import models.Reimbursement;
import models.Status;
import models.User;

import java.util.List;

public interface ReimbursementDAO {

    public List<Reimbursement> reimbursementGetById(Integer authorId);

    public List<Reimbursement> getByStatusId(Integer statusId);

    public void update(Reimbursement unprocessedReimbursement);

    public List<Reimbursement> getAllReimbursements();

    public void create(Reimbursement reimbursement);

}
