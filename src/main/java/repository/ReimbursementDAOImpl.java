package repository;

import models.Reimbursement;
import models.Status;
import util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReimbursementDAOImpl implements ReimbursementDAO{

    @Override
    public List<Reimbursement> reimbursementGetById(Integer authorId) {
        List<Reimbursement> reimbListById = new ArrayList<>();

        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "select  \n" +
                    "\tu.user_first_name, \n" +
                    "\tu.user_last_name, \n" +
                    "\teur.user_role, \n" +
                    "\tr.reimb_amount,\n" +
                    "\tr.reimb_submitted,\n" +
                    "\trs.reimb_status,\n" +
                    "\trt.reimb_type \n" +
                    "from ers_users u\n" +
                    "\tinner join ers_user_roles eur on eur.ers_user_role_id = u.user_roles_fk \n" +
                    "\tinner join ers_reimbursement as r on u.ers_users_id = r.ers_reimbursement_author_fk\n" +
                    "\tinner join ers_reimbursement_type as  rt on rt.reimb_type_id = r.ers_reimbursement_type_fk \n" +
                    "\tinner join ers_reimbursement_status as rs  on rs.reimb_status_id = r.ers_reimbursement_status_id_fk\n" +
                    "\twhere r.ers_reimbursement_author_fk =  ?\n";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, authorId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Reimbursement reimbursement = new Reimbursement();
                reimbursement.setFirstName(rs.getString("user_first_name"));
                reimbursement.setLastName(rs.getString("user_last_name"));
                reimbursement.setUserRole(rs.getString("user_role"));
                reimbursement.setAmount(rs.getDouble("reimb_amount"));
                reimbursement.setSubmittedDate(rs.getDate("reimb_submitted"));
                reimbursement.setStatus(rs.getString("reimb_status"));
                reimbursement.setType(rs.getString("reimb_type"));

                reimbListById.add(reimbursement);
            }


        }catch(SQLException sqle){
            sqle.printStackTrace();
        }
        return reimbListById;
    }


    @Override
    public List<Reimbursement> getByStatusId(Integer statusId) {
        List<Reimbursement> reimbGetByStatus = new ArrayList<>();
        Reimbursement r = new Reimbursement();

        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "select  \n" +
                    "\tu.user_first_name, \n" +
                    "\tu.user_last_name, \n" +
                    "\teur.user_role, \n" +
                    "\tr.reimb_amount,\n" +
                    "\tr.reimb_submitted,\n" +
                    "\trs.reimb_status,\n" +
                    "\trt.reimb_type \n" +
                    "from ers_users u\n" +
                    "\tinner join ers_user_roles eur on eur.ers_user_role_id = u.user_roles_fk \n" +
                    "\tinner join ers_reimbursement as r on u.ers_users_id = r.ers_reimbursement_author_fk\n" +
                    "\tinner join ers_reimbursement_type as  rt on rt.reimb_type_id = r.ers_reimbursement_type_fk \n" +
                    "\tinner join ers_reimbursement_status as rs  on rs.reimb_status_id = r.ers_reimbursement_status_id_fk\n" +
                    "\twhere r.ers_reimbursement_status_id_fk = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, statusId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Reimbursement reimbursement = new Reimbursement();
                reimbursement.setFirstName(rs.getString("user_first_name"));
                reimbursement.setLastName(rs.getString("user_last_name"));
                reimbursement.setUserRole(rs.getString("user_role"));
                reimbursement.setAmount(rs.getDouble("reimb_amount"));
                reimbursement.setSubmittedDate(rs.getDate("reimb_submitted"));
                reimbursement.setStatus(rs.getString("reimb_status"));
                reimbursement.setType(rs.getString("reimb_type"));

                reimbGetByStatus.add(reimbursement);
            }


        }catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        return reimbGetByStatus;
    }

    @Override
    public void update(Reimbursement unprocessedReimbursement) {
        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql =  "update ers_reimbursement set ers_reimbursement_status_id_fk = ? where reimb_id  = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, unprocessedReimbursement.getStatusId());
            ps.setInt(2,unprocessedReimbursement.getReimbId());

            ps.executeUpdate();
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }

    }

    @Override
    public List<Reimbursement> getAllReimbursements() {
        List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();

        String sql = "select  \n" +
                "\tu.user_first_name, \n" +
                "\tu.user_last_name, \n" +
                "\teur.user_role, \n" +
                "\tr.reimb_amount,\n" +
                "\tr.reimb_submitted,\n" +
                "\trs.reimb_status,\n" +
                "\trt.reimb_type \n" +
                "from ers_users u\n" +
                "\tinner join ers_user_roles eur on eur.ers_user_role_id = u.user_roles_fk \n" +
                "\tinner join ers_reimbursement as r on u.ers_users_id = r.ers_reimbursement_author_fk\n" +
                "\tinner join ers_reimbursement_type as  rt on rt.reimb_type_id = r.ers_reimbursement_type_fk \n" +
                "\tinner join ers_reimbursement_status as rs  on rs.reimb_status_id = r.ers_reimbursement_status_id_fk\n";

        try(Connection conn = ConnectionUtil.getConnection()){

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Reimbursement reimbursement = new Reimbursement();
                reimbursement.setFirstName(rs.getString("user_first_name"));
                reimbursement.setLastName(rs.getString("user_last_name"));
                reimbursement.setUserRole(rs.getString("user_role"));
                reimbursement.setAmount(rs.getDouble("reimb_amount"));
                reimbursement.setSubmittedDate(rs.getDate("reimb_submitted"));
                reimbursement.setStatus(rs.getString("reimb_status"));
                reimbursement.setType(rs.getString("reimb_type"));

                reimbursements.add(reimbursement);
            }


        }catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        return reimbursements;
    }

    @Override
    public void create(Reimbursement reimbursement) {
        String sql = "INSERT INTO public.ers_reimbursement\n" +
                "(reimb_amount, reimb_description, ers_reimbursement_status_id_fk, ers_reimbursement_type_fk, ers_reimbursement_author_fk, ers_reimbursement_resolver_fk)\n" +
                "VALUES(?, ?, ?, ?, ?, ?)";

        try(Connection conn = ConnectionUtil.getConnection()) {

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setDouble(1, reimbursement.getAmount());
            ps.setString(2, reimbursement.getDescription());
            ps.setInt(3, reimbursement.getStatusId());
            ps.setInt(4, reimbursement.getTypeId());
            ps.setInt(5, reimbursement.getAuthorId());
            ps.setInt(6, reimbursement.getResolverId());

            ps.executeUpdate();
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }

    }
}
