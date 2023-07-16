package entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static jakarta.persistence.CascadeType.*;
import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Email
    private String email;
    private String password;
    private  Boolean isActive=true;
    private  Boolean isDeleted=false;
    @Transient
    private  Long groupId;

    @CreatedDate
    private LocalDate localDate;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToOne(cascade = {REFRESH,PERSIST,DETACH,MERGE})
    private  Course course;

    @ManyToOne(cascade = {MERGE, REFRESH, DETACH, PERSIST})
    private  Group group;

    @Column(name = "study_format")
    @Enumerated(EnumType.STRING)
    private StudyFormat studyFormat;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
        System.out.println("User");
        System.out.println(role.getAuthority());
        return authorities;
    }



    @Override
    public String getUsername() {
        return email;
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
}
