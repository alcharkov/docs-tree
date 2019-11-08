package lt.alcharkov.docstree.service.impl

import lt.alcharkov.docstree.model.Document
import lt.alcharkov.docstree.repository.DocumentRepositry
import lt.alcharkov.docstree.service.DocumentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import kotlin.collections.ArrayList

@Service
class DocumentServiceImpl: DocumentService {

    @Autowired
    lateinit var documentRepository: DocumentRepositry

    fun recursiveDocumentHierarchyCompile(id: Long? = null, list: ArrayList<Document>): List<Document>{

        if (id != null) {
            val document = documentRepository.findById(id).get()
            list.add(document)
            recursiveDocumentHierarchyCompile(document.parentId, list)
        }

        return list
    }

    override fun getDocumentHierarchy(id: Long): List<Document> {
        val document = documentRepository.findById(id).get()
        val list =  ArrayList<Document>()
        list.add(document)
        return recursiveDocumentHierarchyCompile(document.parentId, list)
    }

    override fun saveDocument(document: Document){
        documentRepository.save(document)
    }
}