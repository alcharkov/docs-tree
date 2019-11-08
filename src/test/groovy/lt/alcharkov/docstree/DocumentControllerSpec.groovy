package lt.alcharkov.docstree

import lt.alcharkov.docstree.model.Document
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import spock.lang.Specification


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DocumentControllerSpec extends Specification {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    def "Find document by id"() {
        when :
        ResponseEntity<Document[]> response =
                restTemplate.getForEntity(
                        "http://localhost:" + port + "/" + "document/1",
                        Document[].class);
        then:
            response.statusCode == HttpStatus.OK
            response.getBody().size() > 0

    }

    def "Add document"() {
        when:
        Document document =  new Document()
        document.setName("Fourth document")
        document.setFile("/home/user/doc4.txt")
        ResponseEntity<String> response = restTemplate.postForEntity(
                "http://localhost:" + port + "/" + "add", document , String.class);
        then:
        response.statusCode == HttpStatus.OK
    }
}