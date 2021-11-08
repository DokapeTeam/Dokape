package com.dokapegroup.dokapebackend.models

import com.dokapegroup.dokapebackend.models.abstract.BaseEntity
import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.OneToOne
import javax.persistence.PrimaryKeyJoinColumn
import javax.persistence.SequenceGenerator
import javax.persistence.Table

@Table(name = "dokape_user")
@Entity
class DBUser(
    @Id
    @SequenceGenerator(
        name = USER_SEQUENCE,
        sequenceName = USER_SEQUENCE,
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = USER_SEQUENCE
    )
    @Column(name = "id")
    override var id: Long? = null,
    var username: String,
    var hashedPassword: String,
    var firstName: String,
    var lastName: String,
    var avatar: String? = null,
    var coverPhoto: String? = null,
    var latitude: Double? = null,
    var longitude: Double? = null,
    var gender: Gender = Gender.Other,
    var dateOfBirth: LocalDate,
    var email: String,
    var phone: String? = null,
    var numberOfPosts: Int = 0,
    var numberOfShorts: Int = 0,
    var numberOfPetsAdopted: Int = 0,
    var trustedOwner: Boolean = false,
    @OneToOne(mappedBy = "user", cascade = [CascadeType.ALL])
    @PrimaryKeyJoinColumn
    var shop: DBShop? = null,
    override var createdAt: LocalDateTime = LocalDateTime.now(),
    override var updatedAt: LocalDateTime = LocalDateTime.now(),
    var role: String,
    @OneToMany(mappedBy = "user")
    var pets: MutableList<DBPet> = mutableListOf()
) : BaseEntity() {
    companion object {
        const val TABLE_NAME = "dokape_user"
        private const val USER_SEQUENCE = "user_sequence"
    }
}
