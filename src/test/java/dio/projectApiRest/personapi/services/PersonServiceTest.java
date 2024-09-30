package dio.projectApiRest.personapi.services;

import dio.projectApiRest.personapi.dto.mapper.PersonMapper;
import dio.projectApiRest.personapi.dto.request.PersonDTO;
import dio.projectApiRest.personapi.dto.response.MessageResponse;
import dio.projectApiRest.personapi.entity.Person;
import dio.projectApiRest.personapi.repository.PersonRepository;
import dio.projectApiRest.personapi.service.PersonService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static dio.projectApiRest.personapi.utils.PersonUtils.createFakeDTO;
import static dio.projectApiRest.personapi.utils.PersonUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @Mock
    private PersonMapper personMapper;

    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenPersonDTOThenReturnSuccessSavedMessage() {
        PersonDTO personDTO = createFakeDTO();
        Person expectedSavedPerson = createFakeEntity();

        when(personMapper.toModel(personDTO)).thenReturn(expectedSavedPerson);
        when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);

        MessageResponse expectedSuccessMessage = createExpectedSuccessMessage(expectedSavedPerson.getId());
        MessageResponse successMessage = personService.create(personDTO);

        assertEquals(expectedSuccessMessage, successMessage);
    }

    private MessageResponse createExpectedSuccessMessage(Long savedPersonId) {
        return MessageResponse.builder()
                .message("Person successfully created with ID " + savedPersonId)
                .build();
    }

}
