package hellojpa.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Member {

    @Id
    private Long id;

    @Column(name = "name")
    private String userName;

    private Integer age;

    @Enumerated(value = EnumType.STRING)
    private RoleType roleType;

    @CreationTimestamp
    private LocalDateTime createdDateTime;

    @UpdateTimestamp
    private LocalDateTime updatedDateTime;

    @Lob
    private String description;

    @Transient
    private String temp;
}
