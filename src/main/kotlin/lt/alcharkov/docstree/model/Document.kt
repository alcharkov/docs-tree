package lt.alcharkov.docstree.model

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import javax.persistence.*

@Entity
@ApiModel
data class Document (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    val id: Long,

    @Column(name = "parent_id", nullable = true)
    var parentId: Long? = null,

    @Column(name = "document_name", nullable = false)
    var name: String,

    @Column(name = "document_file", nullable = false)
    var file: String
) {
}