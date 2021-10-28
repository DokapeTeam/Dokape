package com.dokapegroup.dokapebackend.models

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.MapsId
import javax.persistence.OneToOne
import javax.persistence.Table

@Entity
@Table(name = "shop")
class DBShop(
    @Id
    @Column(name = "user_id")
    var id: Long? = null,
    var name: String,
    var description: String,
    var totalProducts: Int = 0,
    var numberOfFollowers: Int = 0,
    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    var user: DBUser
)
