package dio.projectApiRest.personapi.utils;

import java.time.LocalDate;
import java.util.Collections;

import dio.projectApiRest.personapi.dto.request.PersonDTO;
import dio.projectApiRest.personapi.entity.Person;

public class PersonUtils {

    private static final String FIRST_NAME = "Agnaldo";
    private static final String LAST_NAME = "Leal";
    private static final String CPF_NUMBER = ".663.138-11";
    private static final long PERSON_ID = 1L;
    public static final LocalDate BIRTH_DATE = LocalDate.of(2010, 10, 1);

    public static PersonDTO createFakeDTO() {
        return PersonDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate("04-04-2010")
                .phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
                .build();
    }

    public static Person createFakeEntity() {
        return Person.builder()
                .id(PERSON_ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate(BIRTH_DATE)
                .phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
                .build();
    }
    
}
