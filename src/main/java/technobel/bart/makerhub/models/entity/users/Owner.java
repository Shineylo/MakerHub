package technobel.bart.makerhub.models.entity.users;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("OWNER")
@Getter
@Setter
public class Owner extends User {

    @PrePersist
    public void prePersist() {
        this.setRole("OWNER");
    }

}
