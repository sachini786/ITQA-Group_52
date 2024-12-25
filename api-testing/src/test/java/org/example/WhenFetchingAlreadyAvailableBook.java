package org.example;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
// import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenFetchingAlreadyAvailableBook {

    Long newBookID = null;
    BookApiActions bookApi;

//     @Test
//     public void fetchingAlreadyAvailableBook() {
//         newBookID = bookApi.givenBookIsAvailableInBookStore();
//         bookApi.whenIAskForABookwithId(newBookID);
//         bookApi.thenISeeBookAsResult();
//     }
 }
