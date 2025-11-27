package org.example.granafacil.core.domain.entities;

public class AuthenticatedUser {
    private Long id;
    private String email;

    public AuthenticatedUser(Long id, String email) {
        this.id = id;
        this.email = email;
    }

    public Long getId() { return id; }
    public String getEmail() { return email; }
}
