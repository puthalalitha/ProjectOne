package repository;

import models.Roles;
import models.User;
import util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserDAOImpl implements UserDAO {
    @Override
    public User getUserByUsername(String username) {
        User user = null;

        //retrieve active connection from the database
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "select * from ers_users where ers_username = ?;";

            //preparing sql statement
            PreparedStatement ps = conn.prepareStatement(sql);

            //adding the username into the question mark in the sql statement.
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                user = new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return user;
    }
    @Override
    public void createUser(User user) {
        try (Connection conn = ConnectionUtil.getConnection()) {

            String sql = "insert into ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_roles_fk) values (?, ?, ?, ?, ?, ?);";

            //String sql = "insert into ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_roles_fk) values (?, ?, ?, ?);";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getFirstname());
            ps.setString(4, user.getLastname());
            ps.setString(5, user.getEmail());
            ps.setInt(6, user.getRoleid());

            ps.executeUpdate();

        } catch (SQLException sqle) {
            sqle.printStackTrace();


        }


    }
}