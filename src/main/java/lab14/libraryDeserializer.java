package lab14;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class libraryDeserializer extends StdDeserializer<Library> {

    public libraryDeserializer() {
        super(Library.class);
    }

    @Override
    public Library deserialize(JsonParser jp, DeserializationContext ctx) throws IOException {
        JsonNode node = jp.getCodec().readTree(jp);
        JsonNode libraryNode = node.get("library");

        Library library = new Library();
        library.setName(libraryNode.get("name").asText());
        ArrayNode booksNode = libraryNode.withArray("books");

        ArrayList<Book> books = new ArrayList<>();

        for (JsonNode bookNode : booksNode) {
            Book book = new Book();
            JsonNode titleNode = bookNode.get("title");
            book.setTitle(titleNode.asText());
            JsonNode authorNode = bookNode.get("author");
            book.setAuthor(authorNode.asText());
            JsonNode availbalNode = bookNode.get("available");
            book.setAvailable(availbalNode.asBoolean());
            books.add(book);
        }
        library.setBooks(books);
        return library;
    }
}
