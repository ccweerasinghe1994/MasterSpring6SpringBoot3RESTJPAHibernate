package com.cgnexus.example_19.repository;

import com.cgnexus.example_19.model.Contact;
import com.cgnexus.example_19.rowmappers.ContactRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class ContactRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ContactRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int saveContactMessage(Contact contact) {

        String sql = "INSERT INTO contact_msg (name,mobile_num,email,subject,message,status,created_at,created_by) VALUES (?,?,?,?,?,?,?,?)";

        return jdbcTemplate.update(sql, contact.getName(), contact.getMobileNum(), contact.getEmail(), contact.getSubject(), contact.getMessage(), contact.getStatus(), contact.getCreatedAt(), contact.getCreatedBy());


    }

    public List<Contact> findMessagesWithOpenStatus(String open) {
        String sql = "SELECT * FROM contact_msg  WHERE status = ?";
        return jdbcTemplate.query(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, open);
            }
        }, new ContactRowMapper());
    }

    public int updateStatus(int contactId, String messageStatus, String updatedBy) {

        String sql = "UPDATE contact_msg SET status = ?, updated_by = ?,updated_at = ? WHERE contact_id = ?";
        return jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, messageStatus);
                ps.setString(2, updatedBy);
                ps.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
                ps.setInt(4, contactId);
            }
        });

    }
}
