package com.dokapegroup.dokapebackend.models

import com.dokapegroup.dokapebackend.models.abstract.BaseEntity
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.SequenceGenerator
import javax.persistence.Table

@Entity
@Table
class DBSpeciesType(
    @Id
    @SequenceGenerator(
        name = SPECIES_TYPE_SEQUENCE,
        sequenceName = SPECIES_TYPE_SEQUENCE,
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = SPECIES_TYPE_SEQUENCE
    )
    override var id: Long? = null,
    var name: String,
    @ManyToOne
    @JoinColumn(name = "species_id")
    var species: DBSpecies,
    @OneToMany(mappedBy = "speciesType")
    var pets: MutableList<DBPet> = mutableListOf(),
    override var createdAt: LocalDateTime,
    override var updatedAt: LocalDateTime
) : BaseEntity() {
    companion object {
        private const val SPECIES_TYPE_SEQUENCE = "species_type_sequence"
    }
}
