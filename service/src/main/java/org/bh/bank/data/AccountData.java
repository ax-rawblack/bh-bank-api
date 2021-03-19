package org.bh.bank.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("JpaDataSourceORMInspection")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ACCOUNT", schema = "bh")
public class AccountData implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private int accountId;

    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "balance")
    private double balance;

    @Column(name = "created_Dttm")
    private Timestamp createdDttm;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private List<TransactionData> transactions = new ArrayList<>();
}
