package com.movietime.login.security.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.movietime.mongodb.models.Role;
import com.movietime.mongodb.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import com.fasterxml.jackson.annotation.JsonIgnore;

    public class UserDetailsImpl implements UserDetails {
        private static final long serialVersionUID = 1L;

        private String id;

        private String username;

        private String email;

        @JsonIgnore
        private String password;

        private Role role;

        public UserDetailsImpl(String id, String username, String email, String password,
                               Role role) {
            this.id = id;
            this.username = username;
            this.email = email;
            this.password = password;
            this.role = role;
        }

        public static UserDetailsImpl build(User user) {
            Role role = user.getRole();


            return new UserDetailsImpl(
                    user.getId(),
                    user.getuName(),
                    user.getEmail(),
                    user.getPwd(),
                    role);
        }

        //@Override
        public Role getRole() {
            return role;
        }

        public String getId() {
            return id;
        }

        public String getEmail() {
            return email;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return null;
        }

        @Override
        public String getPassword() {
            return password;
        }

        @Override
        public String getUsername() {
            return username;
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            UserDetailsImpl user = (UserDetailsImpl) o;
            return Objects.equals(id, user.id);
        }
    }

