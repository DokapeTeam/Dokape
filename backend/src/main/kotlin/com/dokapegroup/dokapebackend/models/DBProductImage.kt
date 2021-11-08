package com.dokapegroup.dokapebackend.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table
class DBProductImage(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null,
    var imageUrl: String,
    @ManyToOne
    @JoinColumn(name = "product_id")
    var product: DBProduct
)
