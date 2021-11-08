package com.dokapegroup.dokapebackend.models

import com.dokapegroup.dokapebackend.models.abstract.BaseEntity
import java.time.LocalDateTime
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
    override var id: Long? = null,
    var name: String,
    var description: String,
    var totalProducts: Int = 0,
    var numberOfFollowers: Int = 0,
    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    var user: DBUser,
    override var createdAt: LocalDateTime = LocalDateTime.now(),
    override var updatedAt: LocalDateTime = LocalDateTime.now()
) : BaseEntity()
