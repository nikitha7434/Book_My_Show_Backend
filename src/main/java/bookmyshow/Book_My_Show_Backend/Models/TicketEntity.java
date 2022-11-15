package bookmyshow.Book_My_Show_Backend.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Builder
@EntityListeners(value = {AuditingEntityListener.class})
@Table(name = "ticket_tb")
public class TicketEntity {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name ="Allowcated_Seats",nullable = false)
    private String allowcted_seats;

    @Column(name = "amount",nullable = false)
    double amount;

    @CreatedDate
            @Temporal(TemporalType.TIMESTAMP)
            @Column(name = "booked_at",nullable = false)
  private  Date bookedAt;

    //Done on child class behalf
    @ManyToOne
            @JoinColumn
            @JsonIgnore
    private UserEntity user; // forienKey

    @ManyToOne
    @JsonIgnore
    private ShowEntity show;

@OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
@JsonIgnore
    private List<showSeatEntity> seats;

}
