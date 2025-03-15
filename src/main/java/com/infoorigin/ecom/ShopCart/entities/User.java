package com.infoorigin.ecom.ShopCart.entities;

import com.infoorigin.ecom.ShopCart.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "name is required")
    private String username;

    @Column(nullable = false)
    @NotBlank(message = "password is required")
    private String password;

    @Column(name = "phone_number", nullable = false)
    @NotBlank(message = "phone number is required")
    private String phoneNumber;

    @Column(unique = true)
    @NotBlank(message = "email is required")
    private String email;

    private UserRole role;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderItem> items;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Address address;

    @Column(name = "created_at")
    private final LocalDateTime createdAt = LocalDateTime.now();



}
