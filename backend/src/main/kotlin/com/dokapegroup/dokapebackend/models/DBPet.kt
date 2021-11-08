package com.dokapegroup.dokapebackend.models

import com.dokapegroup.dokapebackend.models.abstract.BaseEntity
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.SequenceGenerator
import javax.persistence.Table

@Entity
@Table
class DBPet(
    @Id
    @SequenceGenerator(
        name = PET_SEQUENCE,
        sequenceName = PET_SEQUENCE,
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = PET_SEQUENCE
    )
    override var id: Long? = null,
    override var createdAt: LocalDateTime,
    override var updatedAt: LocalDateTime,
    var name: String,
    var age: Int,
    var description: String,
    var height: Double,
    var weight: Double,
    var hairType: String,
    var gender: Gender,
    var isAdopted: Boolean = false,
    var tag: String? = null,
    @ManyToOne
    @JoinColumn(name = "species_type_id", nullable = false)
    var speciesType: DBSpeciesType,
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    var user: DBUser
) : BaseEntity() {
    companion object {
        private const val PET_SEQUENCE = "pet_sequence"
    }
}
